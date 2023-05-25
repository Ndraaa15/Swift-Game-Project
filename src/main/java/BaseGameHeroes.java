import java.util.ArrayList;

class BaseGameHeroes {
    private ArrayList<Hero> baseGameHeroes = new ArrayList<>();
    private ArrayList<Boolean> heroIsUsed = new ArrayList<>();

    public BaseGameHeroes() {
        Hero hero0 = new Hero("Murby", 400, 55,  16, HeroElement.FIRE, HeroRole.FIGHTER);
        Hero hero1 = new Hero("Helda", 490, 35,  24, HeroElement.FIRE, HeroRole.TANK);
        Hero hero2 = new Hero("Veld", 300, 50,  10, HeroElement.FIRE, HeroRole.MAGE);
        Hero hero3 = new Hero("Deus", 340, 70,  10, HeroElement.FIRE, HeroRole.ARCHER);

        Hero hero4 = new Hero("Grove", 480, 30,  27, HeroElement.GRASS, HeroRole.TANK);
        Hero hero5 = new Hero("Elisa", 360, 60,  10, HeroElement.GRASS, HeroRole.MAGE);
        Hero hero6 = new Hero("Lily", 380, 70,  12, HeroElement.GRASS, HeroRole.ARCHER);
        Hero hero7 = new Hero("Fara", 380, 35,  20, HeroElement.GRASS, HeroRole.SUPPORT);

        Hero hero8 = new Hero("Theseus", 350, 60,  11, HeroElement.WATER, HeroRole.MAGE);
        Hero hero9 = new Hero("Atla", 375, 70,  11, HeroElement.WATER, HeroRole.ARCHER);
        Hero hero10 = new Hero("Marie", 375, 40,  18, HeroElement.WATER, HeroRole.SUPPORT);
        Hero hero11 = new Hero("Dillo", 425, 60,  16, HeroElement.WATER, HeroRole.FIGHTER);

        hero0.setSkill1(BaseGameSkills.getSkill(0));

        hero1.setSkill1(BaseGameSkills.getSkill(1));
        hero1.setSkill2(BaseGameSkills.getSkill(2));

        hero2.setSkill1(BaseGameSkills.getSkill(3));
        hero2.setSkill2(BaseGameSkills.getSkill(4));

        hero3.setSkill1(BaseGameSkills.getSkill(5));

        hero4.setSkill1(BaseGameSkills.getSkill(6));

        hero5.setSkill1(BaseGameSkills.getSkill(7));

        hero6.setSkill1(BaseGameSkills.getSkill(8));

        hero7.setSkill1(BaseGameSkills.getSkill(9));
        hero7.setSkill2(BaseGameSkills.getSkill(10));

        hero8.setSkill1(BaseGameSkills.getSkill(11));
        hero8.setSkill2(BaseGameSkills.getSkill(12));

        hero9.setSkill1(BaseGameSkills.getSkill(13));

        hero10.setSkill1(BaseGameSkills.getSkill(14));
        hero10.setSkill2(BaseGameSkills.getSkill(15));

        hero11.setSkill1(BaseGameSkills.getSkill(16));

        // SET HERO LORE DAN DESKRIPSI DIBAWAH INI





        //

        add(hero0);
        add(hero1);
        add(hero2);
        add(hero3);

        add(hero4);
        add(hero5);
        add(hero6);
        add(hero7);

        add(hero8);
        add(hero9);
        add(hero10);
        add(hero11);
    }

    private void add(Hero hero) {
        baseGameHeroes.add(hero);
        heroIsUsed.add(false);
    }
    public ArrayList<Hero> getBaseGameHeroes() {
        return baseGameHeroes;
    }

    public Hero getHero(String name) {
        for (Hero hero : baseGameHeroes) {
            if (hero.getName().equals(name)) return hero;
        }
        return null;
    }

    public Hero getHero(int index) {
        if (index > baseGameHeroes.size() || index < 0) return null;
        return baseGameHeroes.get(index);
    }

    public boolean isUsed(String name) {
        for (int i = 0; i < baseGameHeroes.size(); i++) {
            if (baseGameHeroes.get(i).getName().equals(name)) {
                return heroIsUsed.get(i);
            }
        }
        return false;
    }

    public boolean isUsed(int index) {
        if (index > baseGameHeroes.size() || index < 0) return false;
        return heroIsUsed.get(index);
    }

    public void useHero(String name) {
        for (int i = 0; i < baseGameHeroes.size(); i++) {
            if (baseGameHeroes.get(i).getName().equals(name)) {
                heroIsUsed.set(i, true);
                return;
            }
        }
    }

    public void useHero(int index) {
        if (index > baseGameHeroes.size() || index < 0) return;
        heroIsUsed.set(index, true);
    }

}
