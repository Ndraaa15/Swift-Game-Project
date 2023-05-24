import java.util.ArrayList;

enum SkillTarget {
    SINGLE_ENEMY,
    ALL_ENEMY,
    SINGLE_ALLY,
    ALL_ALLY,
    AUTO_ENEMY,
    AUTO_ALLY,
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
    public Heal(String name, int manaCost, SkillTarget target, String description) {
        super(name, manaCost, target, description);
    }

    @Override
    public void useSkill(Hero hero, Hero target) {
        int totalHeal = hero.getAttack() * 2;
        target.setHP(target.getHP() + totalHeal);
        if (target.getHP() > target.getMaxHp()) target.setHP(target.getMaxHp());
        System.out.println("HEAL");
    }
}

class ShadowArrow extends Skill {
    public ShadowArrow(String name, int manaCost, SkillTarget target, String description) {
        super(name, manaCost, target, description);
    }

    public void useSkill(Hero hero, ArrayList<Hero> targets) {

    }
}
