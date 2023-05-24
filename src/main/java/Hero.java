import java.util.ArrayList;

enum HeroElement {
    FIRE,
    WATER,
    GRASS;
}

class Effect {
    private int stunDuration;
    private int tauntDuration;
    private Hero tauntingHero;

    public boolean isStunned() {
        return stunDuration != 0;
    }

    public boolean isTaunted() {
        return tauntDuration != 0;
    }

    public int getStunDuration() {
        return stunDuration;
    }

    public int getTauntDuration() {
        return tauntDuration;
    }

    public void setStunDuration(int stunDuration) {
        this.stunDuration = stunDuration;
    }

    public void setTauntDuration(int tauntDuration) {
        this.tauntDuration = tauntDuration;
        if (tauntDuration == 0) setTauntingHero(null);
    }

    public void setTauntingHero(Hero tauntingHero) {
        this.tauntingHero = tauntingHero;
    }

    public void decrementStunDuration() {
        stunDuration--;
    }

    public void decrementTauntDuration() {
        tauntDuration--;
        if (tauntDuration == 0) setTauntingHero(null);
    }

    public void nullifyStun() {
        stunDuration = 0;
    }

    public void nullifyTaunt() {
        tauntDuration = 0;
        tauntingHero = null;
    }
}

class Hero implements ICharacter{
    private String name;
    private int hp;
    private int maxHp;
    private int mana;
    private int atk;
    private int def;
    private HeroElement heroElement;
    private Effect effect;
    ArrayList<Skill> skills = new ArrayList<>();

    private boolean isDefeated;


    public Hero(String name, int hp, int mana, int atk, int def, HeroElement heroElement) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.atk = atk;
        this.def = def;
        this.heroElement = heroElement;
        this.effect = new Effect();
        this.isDefeated = false;
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
        int totalAtk = (int) (this.getAttack() * damageMultiplier);

        if (totalAtk <= 0) {
            totalAtk = 1;
        }

        opponent.setHP(opponent.getHP() - totalAtk);
        System.out.println(this.getName() + " atk " + opponent.getName() + " dmg: " + totalAtk);
        updateIsDefeated();
    }

    private void updateIsDefeated() {
        if (hp <= 0) {
            setDefeated(true);
            setHP(0);
            System.out.println(getName() + " is defeated");
        }
    }

    public HeroElement getHeroElement() {
        return heroElement;
    }

    @Override
    public boolean isDefeated() {
        return hp <= 0;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public void setAttack(int attack) {
        this.atk = attack;
    }

    @Override
    public void setDefense(int defense) {
        this.def = defense;
    }

    public void setDefeated(boolean defeated) {
        isDefeated = defeated;
    }

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

    @Override
    public int getDefense() {
        return def;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public Skill getSkill(int index) {
        if (index > skills.size() || index < 0) {
            System.out.println("INDEX OT OF BOND");
            return null;
        }
        return skills.get(index);

    }

    public int getSkillCount() {
        return skills.size();
    }

    public void printSkills() {
        for (int i = 0; i < skills.size(); i++) {
            System.out.printf("%d) %s", i, skills.get(i));
        }
    }

    public void printHero() {
        System.out.println(getName());
        System.out.println(getHP());
        System.out.println(getAttack());
        System.out.println(getDefense());
    }
}
