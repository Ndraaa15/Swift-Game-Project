import java.util.ArrayList;

class BaseGameHeroes {
    private ArrayList<Hero> baseGameHeroes = new ArrayList<>();

    public BaseGameHeroes() {
        Hero hero0 = new Hero("Murby", 400, 55,  16, HeroElement.FIRE, HeroRole.FIGHTER);
        Hero hero1 = new Hero("Hellda", 490, 35,  24, HeroElement.FIRE, HeroRole.TANK);
        Hero hero2 = new Hero("Reexana", 300, 50,  10, HeroElement.FIRE, HeroRole.MAGE);
        Hero hero3 = new Hero("Jarriex", 340, 70,  10, HeroElement.FIRE, HeroRole.ARCHER);

        Hero hero4 = new Hero("Zilvanya", 480, 30,  27, HeroElement.GRASS, HeroRole.TANK);
        Hero hero5 = new Hero("Ellisa", 360, 60,  10, HeroElement.GRASS, HeroRole.MAGE);
        Hero hero6 = new Hero("Mayya", 380, 70,  12, HeroElement.GRASS, HeroRole.ARCHER);
        Hero hero7 = new Hero("Faranist", 380, 35,  20, HeroElement.GRASS, HeroRole.SUPPORT);

        Hero hero8 = new Hero("Wallentine", 350, 60,  11, HeroElement.WATER, HeroRole.MAGE);
        Hero hero9 = new Hero("Fannyta", 375, 70,  11, HeroElement.WATER, HeroRole.ARCHER);
        Hero hero10 = new Hero("Pomitar", 375, 40,  18, HeroElement.WATER, HeroRole.SUPPORT);
        Hero hero11 = new Hero("Terryza", 425, 60,  16, HeroElement.WATER, HeroRole.FIGHTER);

        baseGameHeroes.add(hero0);
        baseGameHeroes.add(hero1);
        baseGameHeroes.add(hero2);
        baseGameHeroes.add(hero3);

        baseGameHeroes.add(hero4);
        baseGameHeroes.add(hero5);
        baseGameHeroes.add(hero6);
        baseGameHeroes.add(hero7);

        baseGameHeroes.add(hero8);
        baseGameHeroes.add(hero9);
        baseGameHeroes.add(hero10);
        baseGameHeroes.add(hero11);
    }

    public ArrayList<Hero> getBaseGameHeroes() {
        return baseGameHeroes;
    }

    public Hero getHero(String name) {
        for (Hero hero : baseGameHeroes) {
            if (hero.getName().equals(name)) {
                return hero;
            }
        }
        return null;
    }

    public Hero getHero(int index) {
        if (index > baseGameHeroes.size() || index < 0) return null;
        return baseGameHeroes.get(index);
    }
}
