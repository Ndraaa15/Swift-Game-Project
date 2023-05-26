public class TestMain {
    public static void main(String[] args) {
        Hero hero0 = new Hero("Murby", 400, 55,  16, HeroElement.FIRE, HeroRole.FIGHTER);
        Hero hero1 = new Hero("Helda", 490, 35,  24, HeroElement.FIRE, HeroRole.TANK);

        hero0.setSkill1(new FireballBarage());

        hero0.useSkill1(hero1);
    }
}
