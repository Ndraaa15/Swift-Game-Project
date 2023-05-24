import javax.naming.BinaryRefAddr;

public class App {
    public static void main(String[] args) {
        Display display = new Display();

        GameEngine gameEngine = new GameEngine();
        gameEngine.setDisplay(display);

        gameEngine.start();
    }
}
