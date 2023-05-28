import java.util.*;

enum HeroElement {
    FIRE,
    WATER,
    GRASS,
}

enum HeroRole {
    TANK,
    SUPPORT,
    ARCHER,
    FIGHTER,
    MAGE,
}

class Hero implements IHero {
    private String name;
    private int hp;
    private int maxHp;
    private int mana;
    private int maxMana;
    private int atk;
    private int def;
    private HeroElement heroElement;
    private HeroRole heroRole;
    private Effect effect;


    private Skill skill1;
    private Skill skill2;

    private String heroDescription;
    private String heroLore;

    private boolean isDefeated;

    private boolean isTurn;


    public Hero() {}


    public Hero(String name, int hp, int atk, int def, HeroElement heroElement, HeroRole heroRole) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mana = 100;
        this.maxMana = 100;
        this.atk = atk;
        this.def = def;
        this.heroElement = heroElement;
        this.heroRole = heroRole;
        this.effect = new Effect();
        this.isDefeated = false;
        this.isTurn= false;
    }

    // CLONE
    public Hero(Hero hero) {
        this.name = hero.getName();
        this.hp = hero.getHP();
        this.maxHp = hero.getMaxHp();
        this.mana = 100;
        this.maxMana = 100;
        this.atk = hero.getAttack();
        this.def = hero.getDefense();
        this.heroElement = hero.getHeroElement();
        this.heroRole = hero.getHeroRole();
        this.effect = new Effect();

        this.isDefeated = false;
        this.isTurn = false;

        this.heroDescription = hero.getHeroDescription();
        this.heroLore = hero.getHeroLore();

        this.skill1 = hero.getSkill1();
        this.skill2 = hero.getSkill2();
    }


    public void normalAttack(Hero target) {
        int totalAtk = SkillFunctionality.getAttackAfterEffect(this) - SkillFunctionality.getDefenceAfterEffect(target);
        if (totalAtk <= 0) totalAtk = 1;
        target.setHP(target.getHP() - totalAtk);
        target.updateIsDefeated();

        System.out.println("|===================================================================|");
        System.out.printf("| %-65s |\n", String.format("%s used basic attack on %s", getName(), target.getName()));
        System.out.printf("| %-65s |\n", String.format("dealing %d dmg", totalAtk));
        System.out.println("|===================================================================|");
    }

    public void specialAttack(Hero target) {
        HeroElement attackerElement = this.getHeroElement();
        HeroElement opponentElement = target.getHeroElement();

        int damageMultiplier = 1;

        if (attackerElement == heroElement.FIRE && opponentElement == heroElement.GRASS) {
            damageMultiplier = 2;
        } else if (attackerElement == heroElement.GRASS && opponentElement == heroElement.WATER) {
            damageMultiplier = 2;
        } else if (attackerElement == heroElement.WATER && opponentElement == heroElement.FIRE) {
            damageMultiplier = 2;
        }
        int totalAtk = (SkillFunctionality.getAttackAfterEffect(this) * damageMultiplier) - SkillFunctionality.getDefenceAfterEffect(target) ;

        if (totalAtk <= 0) totalAtk = 1;

        target.setHP(target.getHP() - totalAtk);
        target.updateIsDefeated();
        System.out.println("|===================================================================|");
        System.out.printf("| %-65s |\n", String.format("%s special attack on %s", getName(), target.getName()));
        System.out.printf("| %-65s |\n", String.format("dealing %d dmg", totalAtk));
        System.out.println("|===================================================================|");
    }

    @Override
    public void updateIsDefeated() {
        if (hp <= 0) {
            setDefeated(true);
            setHP(0);
            setMana(0);
            getEffect().nullifyAll();
            System.out.println("|===================================================================|");
            System.out.printf("| %-65s |\n", String.format("%s is defeated",getName() ));
            System.out.println("|===================================================================|");
        }
    }

    // HERO ATRIBUTES (SETTER)
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAttack(int attack) {
        this.atk = attack;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
        if (this.mana < 0) this.mana = 0;
        if (this.mana > maxMana) this.mana = maxMana;
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
        if (this.hp < 0) this.hp = 0;
        if (this.hp > maxHp) this.hp = maxHp;
    }

    @Override
    public void setDefense(int defense) {
        this.def = defense;
    }

    @Override
    public void setDefeated(boolean isDefeated) {
        this.isDefeated = isDefeated;
    }

    @Override
    public void setHeroDescription(String heroDescription) {
        this.heroDescription = heroDescription;
    }

    @Override
    public void setHeroLore(String heroLore) {
        this.heroLore = heroLore;
    }

    // HERO ATRIBUTES (GETTER)
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getAttack() {
        return atk;
    }

    @Override
    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public int getDefense() {
        return def;
    }

    @Override
    public HeroElement getHeroElement() {
        return heroElement;
    }

    @Override
    public HeroRole getHeroRole() {
        return heroRole;
    }

    @Override
    public String getHeroDescription() {
        return heroDescription;
    }

    @Override
    public String getHeroLore() {
        return heroLore;
    }


    // SKILLS
    @Override
    public Effect getEffect() {
        return effect;
    }

    @Override
    public boolean hasSkill1() {
        return skill1 != null;
    }

    @Override
    public boolean hasSkill2() {
        return skill2 != null;
    }

    @Override
    public void setSkill1(Skill skill1) {
        this.skill1 = skill1;
    }

    @Override
    public void setSkill2(Skill skill2) {
        this.skill2 = skill2;
    }

    @Override
    public Skill getSkill1() {
        return skill1;
    }

    @Override
    public Skill getSkill2() {
        return skill2;
    }

    @Override
    public SkillTarget getSkill1Target() {
        if (!hasSkill1()) return null;
        return skill1.getTarget();
    }

    @Override
    public SkillTarget getSkill2Target() {
        if (!hasSkill2()) return null;
        return skill2.getTarget();
    }

    @Override
    public boolean hasEnoughManaSkill1() {
        if (!hasSkill1()) return false;
        return skill1.hasEnoughMana(this);
    }

    @Override
    public boolean hasEnoughManaSkill2() {
        if (!hasSkill2()) return false;
        return skill2.hasEnoughMana(this);
    }

    // SKILL USAGE
    @Override
    public void useSkill1(ArrayList<Hero> targets) {
        if (!hasSkill1() || !hasEnoughManaSkill1()) return;
        skill1.useSkill(this, targets);
    }

    @Override
    public void useSkill1(Hero target) {
        if (!hasSkill1() || !hasEnoughManaSkill1()) return;
        skill1.useSkill(this, target);
    }

    @Override
    public void useSkill2(ArrayList<Hero> targets) {
        if (!hasSkill2() || !hasEnoughManaSkill2()) return;
        skill2.useSkill(this, targets);
    }

    @Override
    public void useSkill2(Hero target) {
        if (!hasSkill2() || !hasEnoughManaSkill2()) return;
        skill2.useSkill(this, target);
    }

    // CONDITION
    @Override
    public boolean isDefeated() {
        return isDefeated;
    }

    @Override
    public void makeAlive() {
        isDefeated = false;
    }

    public String getCondition() {
        if (isDefeated) {
            return "DEFEATED";
        }
        String display = "FX   : ";
        display +=  getEffect().getEffectDisplay();
        if (display.equals("FX   : null")) return "FX   :";
        return display;
    }

    public void incrementManaPerTurn() {
        setMana(getMana() + 10);
    }

    // DISPLAY
    @Override
    public void printHero() {
        System.out.println(getName());
        System.out.println(getHP());
        System.out.println(getAttack());
        System.out.println(getDefense());
    }

    @Override
    public void setHeroElement(HeroElement heroElement) {
        this.heroElement = heroElement;
    }

    @Override
    public void setHeroRole(HeroRole heroRole) {
        this.heroRole = heroRole;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        this.isTurn = turn;
    }
}
