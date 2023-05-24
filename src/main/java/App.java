import javax.naming.BinaryRefAddr;

public class App {
    public static void main(String[] args) {
        BaseGameHeroes heroes = new BaseGameHeroes();

        Display display = new Display();

        GameEngine gameEngine = new GameEngine();
        gameEngine.setDisplay(display);
        gameEngine.setHeroes(heroes);

        gameEngine.start();
    }
}
