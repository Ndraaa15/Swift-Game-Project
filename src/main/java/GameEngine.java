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
        display.readyGameDisplay(this.playerParty);
    }

    private void _exitGame (){
        System.exit(0);
    }

    private void _createPartyForPlayer (){
        display.createTeam();
        String partyName = sc.nextLine();

        System.out.println("Choose your 3 heroes !!!");
        display.listHero();
        ICharacter [] characters = new ICharacter[3];
        for (int i = 0; i < 3; i++) {
//            characters[i] = new Character();
        }

        this.playerParty = createPlayerParty(partyName, characters[0], characters[1], characters[2]);


        display.readyGameDisplay(this.playerParty);

        String select = sc.nextLine();
        boolean isTrue = true;
        do {
            switch (select) {
                case "Y" -> {
                    isTrue = false;
                    _createPartyForCPU();
                    gameON();
                }
                case "n" -> {
                    isTrue = false;
                    _createPartyForPlayer();
                }
                default -> System.out.println("Please choose between (Y | n) !!!");
            }
        }while (isTrue);
    }


    private void gameON (){
        display.gameField(this.playerParty, this.cpuParty);

    }

    private void _createPartyForCPU (){
        String partyName = "COM";
        ICharacter [] characters = new ICharacter[3];
        for (int i = 0; i < 3; i++) {
//            characters[i] = new Character();
        }

        this.cpuParty = createCPUParty(partyName, characters[0], characters[1], characters[2]);

    }

    private void _createHero (){

    }
}
