/*
* Team :
* -) Gede Indra Adi Brata (225150200111006)
* -) LUCAS CHANDRA (225150200111009)
* -) JAVIER AAHMES REANSYAH (225150201111001)
* -) RAFIQI AHMAD HANAFIAH NASUTION (225150207111011)
* -) GRATIA YUDIKA MORADO SILALAHI (225150207111015)
*/


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
