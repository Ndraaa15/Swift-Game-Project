import java.util.ArrayList;

enum SkillTarget {
    SINGLE_ENEMY,
    ALL_ENEMY,
    SINGLE_ALLY,
    ALL_ALLY,
    DEAD_ALLY,
    SELF,
}

class Skill {
    private String name;
    private int manaCost;
    private SkillTarget target;
    private String description;

    public Skill(String name, int manaCost, SkillTarget target, String description) {
        this.name = name;
        this.manaCost = manaCost;
        this.target = target;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public boolean hasEnoughMana(Hero hero) {
        return hero.getMana() > manaCost;
    }

    public void deductMana(Hero hero) {
        hero.setMana(hero.getMana() - getManaCost());
    }

    public SkillTarget getTarget() {
        return target;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return String.format(getName());
    }

    public void useSkill(Hero hero, Hero target) {
        System.out.println("ERR 1");
    }

    public void useSkill(Hero hero, ArrayList<Hero> targets) {
        System.out.println("ERR 2");
    }

    public void useSkill(Hero hero) {
        System.out.println("ERR 3");
    }
}
// MURBY
class FireballBarage extends Skill {

    private double damageMultiplier = 3;
    public FireballBarage() {
        super("Fireball Barage", 50, SkillTarget.SINGLE_ENEMY, "Deal 3x basic attack damage to an enemy");
    }

    public void useSkill(Hero hero, Hero target) {
        if (!hasEnoughMana(hero)) return;
        SkillFunctionality.modifiedBasicAtack(hero, target, damageMultiplier);
        target.updateIsDefeated();
        deductMana(hero);
    }

}

// HELLDA
class AshenGrowl extends Skill {
    int duration = 3;
    double damageMultiplier = 0.5;
    public AshenGrowl() {
        super("Ashen Growl", 55, SkillTarget.SINGLE_ENEMY, "Deal half basic attack and taunt an enemy for 3 turns");
    }

    public void useSkill(Hero hero, Hero target) {
        SkillFunctionality.taunt(hero, target, duration);
        SkillFunctionality.modifiedBasicAtack(hero, target, damageMultiplier);
        target.updateIsDefeated();
        deductMana(hero);

    }
}
class FlameArmor extends Skill {
    private int duration = 5;
    private double defMultiplier = 1.15;
    public FlameArmor() {
        super("Flame Armor", 60, SkillTarget.ALL_ALLY, "Increase all ally defense by 15% for 5 turns");
    }

    public void useSkill(Hero hero, ArrayList<Hero> targets) {
        if (!hasEnoughMana(hero)) return;
        for (Hero target : targets) {
            if (target.isDefeated()) continue;
            SkillFunctionality.defBuff(target, duration, defMultiplier);
        }
        deductMana(hero);
    }
}

// VELDORA
class ArmorBurn extends Skill {
    private int duration = 3;
    private double debuffMultiplier = 0.6;
    private double damageMultiplier = 0.2;

    public ArmorBurn() {
        super("Armor Burn", 65, SkillTarget.ALL_ENEMY, "Decrease 60% defense for 3 turns and deal 20% basic attack to all enemy");
    }

    public void useSkill(Hero hero, ArrayList<Hero> targets) {
        if (!hasEnoughMana(hero)) return;
        for (Hero target : targets) {
            SkillFunctionality.defDebuff(target, duration, debuffMultiplier);
            SkillFunctionality.modifiedBasicAtack(hero, target, damageMultiplier);
            target.updateIsDefeated();
        }
        deductMana(hero);
    }
}

class FireStaff extends Skill {
    int duration = 3;
    double atkMultiplier = 2.0;
    public FireStaff() {
        super("Fire Staff", 30, SkillTarget.SELF, "Increase hero attack by 2x for 3 turns");
    }

    @Override
    public void useSkill(Hero hero) {
        if (!hasEnoughMana(hero)) return;
        SkillFunctionality.atkBuff(hero, duration, atkMultiplier);
        deductMana(hero);
    }
}

// Deus
class InfernalShot extends Skill {
    double damageMultiplier = 1.5;
    int duration = 1;
    public InfernalShot() {
        super("Infernal Shot", 30, SkillTarget.SINGLE_ENEMY, "Stun and deal 1.5 damage to an enemy");
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        if (!hasEnoughMana(hero)) return;
        SkillFunctionality.modifiedBasicAtack(hero, target, damageMultiplier);
        SkillFunctionality.stun(target, duration);
        deductMana(hero);
    }
}

// Greysan
class GrassrootGuardian extends Skill {
    double healMultiplier = 0.1;
    double defBuffMultiplier = 0.2;
    public GrassrootGuardian() {
        super("Grassroot Guardian", 60, SkillTarget.ALL_ALLY, "10% heal and 20% def buff for 2 turns to all ally");
    }

    @Override
    public void useSkill(Hero hero, ArrayList<Hero> targets) {
        if (!hasEnoughMana(hero)) return;
        for (Hero target : targets) {
            SkillFunctionality.healMaxHpBase(target, healMultiplier);
            SkillFunctionality.defBuff(target, 2, defBuffMultiplier);
        }
        deductMana(hero);
    }
}

// ELLISA
class DrainingVine extends Skill {
    private double multiplier = 0.5;
    public DrainingVine() {
        super("Draining Vine", 85, SkillTarget.SINGLE_ENEMY, "Drain 50% max mana and HP");
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        if (!hasEnoughMana(hero)) return;
        SkillFunctionality.healthDrainMaxHealth(target, multiplier);
        SkillFunctionality.manaDrainMaxManaBase(target, multiplier);
        deductMana(hero);
    }
}


