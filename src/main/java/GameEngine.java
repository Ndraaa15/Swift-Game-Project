import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine implements IGameEngine{
    private BaseGameHeroes heroes;
    private Scanner sc = new Scanner(System.in);
    private IParty playerParty;
    private IParty cpuParty;
    private Display display;

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setHeroes (BaseGameHeroes heroes){
        this.heroes = heroes;
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
        display.brawlHeroes();
        display.menuGame();

        boolean isTrue = true;
        while (isTrue){
            String select = sc.nextLine();
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
                    isTrue = false;
                    _exitGame();
                }
                default -> {
                    System.out.println("Please choose between (a | b | c) !!!");
                    System.out.print("Your Choice : ");
                }
            }
        }

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

        display.listHero();

        ArrayList <String> numbers = new ArrayList<>(3);
        ArrayList <Hero> heroes = new ArrayList<>(3);


        for (int i = 0; i < 3; i++) {
            System.out.println("Heroes " + (i + 1) + " : ");
            String select = sc.nextLine();
            numbers.add(select);

        }

        this.playerParty = createPlayerParty(partyName, heroes.get(0), heroes.get(1), heroes.get(2));


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

        }

        this.cpuParty = createCPUParty(partyName, characters[0], characters[1], characters[2]);

    }

    private void _createHero (){

    }

    private Hero selectHero (String select) {
        Hero temp = null;

        ArrayList<Hero> listHeroes = heroes.getBaseGameHeroes();

        if (select.equals("1")){
            temp = heroes.getHero("Murby");
        } else if (select.equals("2")) {
            temp = heroes.getHero("Helda");
        } else if (select.equals("3")) {
            temp = heroes.getHero("Veldora");
        } else if (select.equals("4")){
            temp = heroes.getHero("Deus");
        } else if (select.equals("5")){
            temp = heroes.getHero("Greysn");
        } else if (select.equals("6")){
            temp = heroes.getHero("Elisa");
        } else if (select.equals("7")){
            temp = heroes.getHero("Lily");
        } else if (select.equals("8")){
            temp = heroes.getHero("Fara");
        } else if (select.equals("9")){
            temp = heroes.getHero("Theseus");
        } else if (select.equals("10")){
            temp = heroes.getHero("Atla");
        } else if (select.equals("11")){
            temp = heroes.getHero("Pomi");
        } else if (select.equals("12")){
            temp = heroes.getHero("Marie");
        }

        return temp;
    }
}
