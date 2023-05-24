import java.util.ArrayList;

enum SkillTarget {
    SINGLE_ENEMY,
    ALL_ENEMY,
    SINGLE_ALLY,
    ALL_ALLY,
    DEAD_ALLY,
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
        return hero.getMana() < manaCost;
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
}

class Heal extends Skill {
    private int healMultiplier;
    public Heal(String name, int manaCost, String description, int healMultiplier) {
        super(name, manaCost, SkillTarget.SINGLE_ALLY, description);
        this.healMultiplier = healMultiplier;
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        int totalHeal = hero.getAttack() * healMultiplier;
        target.setHP(target.getHP() + totalHeal);
        if (target.getHP() > target.getMaxHp()) target.setHP(target.getMaxHp());
        System.out.println("HEAL");
    }
}

class AoE extends Skill {
    private double atkMultiplier;
    public AoE(String name, int manaCost, String description, double atkMultiplier) {
        super(name, manaCost, SkillTarget.ALL_ENEMY, description);
        this.atkMultiplier = atkMultiplier;
    }

    @Override
    public void useSkill(Hero hero, ArrayList<Hero> targets) {
        for (Hero target : targets) {
            int totalAtk = ((int) (hero.getAttack() * atkMultiplier)) - target.getDefense();
            if (totalAtk <= 0) totalAtk = 1;
            target.setHP(target.getHP() - totalAtk);
            target.updateIsDefeated();

            deductMana(hero);
        }
    }
}

class SingleStun extends Skill {
    private int duration;

    public SingleStun(String name, int manaCost, String description, int duration) {
        super(name, manaCost, SkillTarget.SINGLE_ENEMY, description);
        this.duration = duration;
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        hero.getEffect().setStunDuration(duration);
        System.out.println(target.getName() + " is stunned for" + duration + " turns");

        deductMana(hero);
    }
}

class SingleResurrect extends Skill {
    public SingleResurrect(String name, int manaCost, String description) {
        super(name, manaCost, SkillTarget.DEAD_ALLY, description);
    }
    @Override
    public void useSkill(Hero hero, Hero target) {
        target.makeAlive();
        target.setHP((int) (0.5 * target.getMaxHp()));

        deductMana(hero);
    }
}

class SinglePurify extends Skill {
    public SinglePurify(String name, int manaCost, String description) {
        super(name, manaCost, SkillTarget.SINGLE_ALLY, description);
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        target.getEffect().nullifyAllDebuff();
        System.out.println("EFFECT NULLIFIED");

        deductMana(hero);
    }
}

class SingleTaunt extends Skill {
    private int duration;
    public SingleTaunt(String name, int manaCost, String description, int duration) {
        super(name, manaCost, SkillTarget.SINGLE_ENEMY, description);
        this.duration = duration;
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        target.getEffect().setTauntDuration(duration);
        target.getEffect().setTauntingHero(hero);

        deductMana(hero);
    }
}

class SingleManaDrain extends Skill {
    private double drainMultiplier;
    public SingleManaDrain(String name, int manaCost, String description, double atkMultiplier) {
        super(name, manaCost, SkillTarget.SINGLE_ENEMY, description);
        this.drainMultiplier = atkMultiplier;
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        int totalDrain = (int) (hero.getAttack() * drainMultiplier);
        target.setMana(target.getMana() - totalDrain);

        deductMana(hero);
    }
}
