import java.util.ArrayList;

public interface IHero {
    // dapat berakibat berkurangnya HP lawan
    // damage yang dihasilkan normalAttack tidak bergantung pada tipe karakter
    public void normalAttack(IHero opponent);

    // dapat berakibat berkurangnya HP lawan
    // damage yang dihasilkan specialAttack bergantung pada tipe karakter
    public void specialAttack(IHero opponent);

    public void updateIsDefeated();

    // untuk mengetahui apakah player sudah dikalahkan (HP <= 0) atau masih bisa digunakan


    // methods di bawah ini terkait dengan atribut karakter:

    public void setName(String name);

    public void setHP(int hp);

    public void setAttack(int attack);

    public void setMana(int mana);

    public void setDefense(int defense);

    public String getName();

    public int getHP();

    public int getAttack();

    public int getMana();

    public int getDefense();

    public void setDefeated(boolean isDefeated);

    public void setHeroDescription(String heroDescription);

    public void setHeroLore(String heroLore);

    public int getMaxHp();

    public HeroElement getHeroElement();

    public HeroRole getHeroRole();

    public String getHeroDescription();

    public String getHeroLore();

    public Effect getEffect();

    public boolean hasSkill1();

    public boolean hasSkill2();

    public void setSkill1(Skill skill1);

    public void setSkill2(Skill skill2);

    public Skill getSkill1();

    public Skill getSkill2();

    public SkillTarget getSkill1Target();

    public SkillTarget getSkill2Target();

    public boolean hasEnoughManaSkill1();

    public boolean hasEnoughManaSkill2();

    public void useSkill1(ArrayList<Hero> targets);

    public void useSkill1(Hero target);

    public void useSkill2(ArrayList<Hero> targets);

    public void useSkill2(Hero target);


    public boolean isDefeated();

    public void makeAlive();

    public void printHero();

    public void setHeroElement(HeroElement heroElement);

    public void setHeroRole(HeroRole heroRole);

}
