import java.util.Scanner;

public class GameEngine implements IGameEngine{
    private Scanner sc = new Scanner(System.in);
    private IParty playerParty;
    private IParty cpuParty;
    private Display display;

    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public IParty createPlayerParty(String partyName, ICharacter ICharacter1, ICharacter ICharacter2, ICharacter ICharacter3) {

        return new Party(partyName, ICharacter1, ICharacter2, ICharacter3);
    }

    @Override
    public IParty createCPUParty(String partyName, ICharacter ICharacter1, ICharacter ICharacter2, ICharacter ICharacter3) {
        return new Party(partyName, ICharacter1, ICharacter2, ICharacter3);
    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public IParty nextTurn() {
        return null;
    }

    @Override
    public IParty winner() {
        return null;
    }

    public void start (){
        display.menuGame();
        String select = sc.nextLine();
        boolean isTrue = true;
        do {
            switch (select) {
                case "a" -> {
                    isTrue = false;
                    _newGame();
                }
                case "b" -> {
                    isTrue = false;
                    _loadGame();
                }
                case "c" -> {
                    _exitGame();
                    isTrue = false;
                }
                default -> System.out.println("Please choose between (a | b | c) !!!");
            }
        }while (isTrue);
    }

    private void _newGame (){
        display.newGameMenu();
        String select = sc.nextLine();
        boolean isTrue = true;
        do {
            switch (select) {
                case "a" -> {
                    isTrue = false;
                    _createPartyForPlayer();
                }
                case "b" -> {
                    isTrue = false;
                    _createHero();
                }
                case "c" -> {
                    isTrue = false;
                    start();
                }
                default -> System.out.println("Please choose between (a | b | c) !!!");
            }
        }while (isTrue);
    }

    private void _loadGame (){
        display.readyGameDisplay();
    }

    private void _exitGame (){
        System.exit(0);
    }

    private void _createPartyForPlayer (){


        display.listHero();



        display.readyGameDisplay();



        gameON();

    }


    private void gameON (){
        display.gameField(playerParty, cpuParty);
    }

    private void _createPartyForCPU (){

    }

    private void _createHero (){

    }
}
