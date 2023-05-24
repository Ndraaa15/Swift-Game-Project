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
        System.out.println("PLACEHOLDER SINGLE");
    }

    public void useSkill(Hero hero, ArrayList<Hero> targets) {
        System.out.println("PLACEHOLDER MULTI");
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
        }
    }
}

class Stun extends Skill {
    private int duration;

    public Stun(String name, int manaCost, String description, int duration) {
        super(name, manaCost, SkillTarget.SINGLE_ENEMY, description);
        this.duration = duration;
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        hero.getEffect().setStunDuration(duration);
        System.out.println(target.getName() + " is stunned for" + duration + " turns");
    }
}

class Resurrect extends Skill {
    public Resurrect(String name, int manaCost, String description) {
        super(name, manaCost, SkillTarget.DEAD_ALLY, description);
    }
    @Override
    public void useSkill(Hero hero, Hero target) {
        target.makeAlive();
        target.setHP((int) (0.5 * target.getMaxHp()));
    }
}

class Purify extends Skill {
    public Purify(String name, int manaCost, String description) {
        super(name, manaCost, SkillTarget.SINGLE_ALLY, description);
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        target.getEffect().nullifyAll();
        System.out.println("EFFECT NULLIFIED");
    }
}

class Taunt extends Skill {
    private int duration;
    public Taunt(String name, int manaCost, String description, int duration) {
        super(name, manaCost, SkillTarget.SINGLE_ENEMY, description);
        this.duration = duration;
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        target.getEffect().setTauntDuration(duration);
        target.getEffect().setTauntingHero(hero);
    }
}
