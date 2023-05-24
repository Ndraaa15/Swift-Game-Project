import java.util.ArrayList;

enum HeroElement {
    FIRE,
    WATER,
    GRASS;
}

enum HeroRole {
    TANK,
    SUPPORT,
    ARCHER,
    FIGHTER,
    MAGE,
}

class Hero implements ICharacter{
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

        this.heroDescription = hero.getHeroDescription();
        this.heroLore = hero.getHeroLore();

        this.skill1 = hero.getSkill1();
        this.skill2 = hero.getSkill2();
    }

    @Override
    public void normalAttack(ICharacter opponent) {
        int totalAtk = this.atk - opponent.getDefense();
        if (totalAtk <= 0) totalAtk = 1;
        opponent.setHP(opponent.getHP() - totalAtk);
        System.out.println(this.name + " atk " + opponent.getName() + " dmg: " + totalAtk);
        updateIsDefeated();
    }

    @Override
    public void specialAttack(ICharacter opponent) {
        HeroElement attackerElement = this.getHeroElement();
        HeroElement opponentElement = opponent.getHeroElement();

        int damageMultiplier = 1;

        if (attackerElement == heroElement.FIRE && opponentElement == heroElement.GRASS) {
            damageMultiplier = 2;
        } else if (attackerElement == heroElement.GRASS && opponentElement == heroElement.WATER) {
            damageMultiplier = 2;
        } else if (attackerElement == heroElement.WATER && opponentElement == heroElement.FIRE) {
            damageMultiplier = 2;
        }
        int totalAtk = this.getAttack() * damageMultiplier;

        if (totalAtk <= 0) {
            totalAtk = 1;
        }

        opponent.setHP(opponent.getHP() - totalAtk);
        System.out.println(this.getName() + " atk " + opponent.getName() + " dmg: " + totalAtk);
        updateIsDefeated();
    }

    public void updateIsDefeated() {
        if (hp <= 0) {
            setDefeated(true);
            setHP(0);
            System.out.println(getName() + " is defeated");
        }
    }

    public void manaRegenPerTurn() {
        int regenPerTurn = 10;
        mana += regenPerTurn;
        if (mana > maxMana) mana = maxMana;
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

    public void setMana(int mana) {
        this.mana = mana;
        if (this.mana < 0) this.mana = 0;
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public void setDefense(int defense) {
        this.def = defense;
    }

    public void setDefeated(boolean isDefeated) {
        this.isDefeated = isDefeated;
    }

    public void setHeroDescription(String heroDescription) {
        this.heroDescription = heroDescription;
    }

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

    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getAttack() {
        return atk;
    }

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

    public HeroElement getHeroElement() {
        return heroElement;
    }

    public HeroRole getHeroRole() {
        return heroRole;
    }

    public String getHeroDescription() {
        return heroDescription;
    }

    public String getHeroLore() {
        return heroLore;
    }

    // SKILLS
    public Effect getEffect() {
        return effect;
    }

    public boolean hasSkill1() {
        return skill1 != null;
    }

    public boolean hasSkill2() {
        return skill2 != null;
    }

    public void setSkill1(Skill skill1) {
        this.skill1 = skill1;
    }

    public void setSkill2(Skill skill2) {
        this.skill2 = skill2;
    }

    public Skill getSkill1() {
        return skill1;
    }

    public Skill getSkill2() {
        return skill2;
    }

    public SkillTarget getSkill1Target() {
        if (!hasSkill1()) return null;
        return skill1.getTarget();
    }

    public SkillTarget getSkill2Target() {
        if (!hasSkill2()) return null;
        return skill2.getTarget();
    }

    public boolean hasEnoughManaSkill1() {
        if (!hasSkill1()) return false;
        return skill1.hasEnoughMana(this);
    }

    public boolean hasEnoughManaSkill2() {
        if (!hasSkill2()) return false;
        return skill2.hasEnoughMana(this);
    }

    // SKILL USAGE
    public void useSkill1(ArrayList<Hero> targets) {
        if (!hasSkill1() || !hasEnoughManaSkill1()) return;
        skill1.useSkill(this, targets);
    }

    public void useSkill1(Hero target) {
        if (!hasSkill1() || !hasEnoughManaSkill1()) return;
        skill1.useSkill(this, target);
    }

    public void useSkill2(ArrayList<Hero> targets) {
        if (!hasSkill2() || !hasEnoughManaSkill2()) return;
        skill2.useSkill(this, targets);
    }

    public void useSkill2(Hero target) {
        if (!hasSkill2() || !hasEnoughManaSkill2()) return;
        skill2.useSkill(this, target);
    }

    // CONDITION
    @Override
    public boolean isDefeated() {
        return isDefeated;
    }

    public void makeAlive() {
        isDefeated = false;
    }

    // DISPLAY
    public void printHero() {
        System.out.println(getName());
        System.out.println(getHP());
        System.out.println(getAttack());
        System.out.println(getDefense());
    }
}
