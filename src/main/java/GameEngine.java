import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameEngine implements IGameEngine{
    Random random = new Random();
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
    public IParty createPlayerParty(String partyName, Hero ICharacter1, Hero ICharacter2, Hero ICharacter3) {

        return new Party(partyName, ICharacter1, ICharacter2, ICharacter3);
    }

    @Override
    public IParty createCPUParty(String partyName, Hero ICharacter1, Hero ICharacter2, Hero ICharacter3) {
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
        IParty a = createPlayerParty("Indra", heroes.getHero(0), heroes.getHero(1), heroes.getHero(2));
        IParty b = createPlayerParty("COM", heroes.getHero(3), heroes.getHero(4), heroes.getHero(5));
        display.gameField(a, b);


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

        ArrayList <Hero> listHeroes = new ArrayList<>();

        int i = 1;
        while (listHeroes.size() < 3){
            System.out.print("Heroes " + (i) + " : ");
            String select = sc.nextLine();

            Hero result = selectHero(select);

            if (listHeroes.contains(result)){
                System.out.println("            Hero already selected, choose other heroes !!!                     ");
            }else {
                if (result != null){
                    listHeroes.add(result);
                    System.out.println("                          " + result.getName() + " selected !              ");
                    i++;
                }else {
                    System.out.println("Please choose heroes between 1 - 12 !!!");
                }
            }
        }

        this.playerParty = createPlayerParty(partyName, listHeroes.get(0), listHeroes.get(1), listHeroes.get(2));

        display.readyGameDisplay(this.playerParty);

        String select = sc.nextLine();
        boolean isTrue = true;
        do {
            switch (select) {
                case "y" -> {
                    isTrue = false;
                    _createPartyForCPU();
                    gameON();
                }
                case "n" -> {
                    isTrue = false;
                    _createPartyForPlayer();
                }
                default -> System.out.println("Please choose between (y | n) !!!");
            }
        }while (isTrue);
    }


    private void gameON (){
        int rNUm = random.nextInt(2);
        if (rNUm == 0){
            playerParty.setTurn(true);
            cpuParty.setTurn(false);
        }else {
            playerParty.setTurn(false);
            cpuParty.setTurn(true);
        }

        while (!playerParty.isDefeated() && !cpuParty.isDefeated()){
            display.gameField(this.playerParty, this.cpuParty);

            if (playerParty.isTurn()){
                System.out.println("---------------------------------------------------------------------");
                System.out.println("|                            Your Turn                              |");
                System.out.println("---------------------------------------------------------------------");
                playerTurn();

                playerParty.setTurn(false);
                cpuParty.setTurn(true);

            }else if (cpuParty.isTurn()){
                System.out.println("---------------------------------------------------------------------");
                System.out.println("|                             COM Turn                              |");
                System.out.println("---------------------------------------------------------------------");
                cpuTurn();

                cpuParty.setTurn(false);
                playerParty.setTurn(true);
            }
        }

        if (playerParty.isDefeated()){
            display.winnerBanner(this.cpuParty);
        }else {
            display.winnerBanner(this.playerParty);
        }

        display.playAgainOrNo();
        String select = sc.nextLine();

        if (select.equals("y")){

        } else if (select.equals("s")) {

        } else if (select.equals("x")) {
            display.thankYou();
            _exitGame();
        }
    }

    private void cpuTurn(){
        ArrayList<Hero> listHero = playerParty.getCharacters();
        ArrayList<Hero> listEnemy = cpuParty.getCharacters();

        while ((!listHero.get(0).isTurn() && !listHero.get(0).isDefeated()) || (!listHero.get(1).isTurn() && !listHero.get(1).isDefeated()) || (!listHero.get(2).isTurn() && !listHero.get(2).isDefeated())){
            System.out.println("Choose your hero  : ");
            String select = sc.nextLine();

            Hero hero = listHero.get(Integer.parseInt(select) - 1);

            if (hero.isTurn()){
                System.out.println("Please choose another hero, hero already used!");
                continue;
            }

            if (hero.hasSkill1()){
                display.hasSkill1(hero);
            } else if (hero.hasSkill2()) {
                display.hasSkill2(hero);
            }

            boolean isTrue = true;
            while (isTrue){
                System.out.println("Choose your skill : ");
                select = sc.nextLine();
                if (select.equals("1")){
                    display.listEnemy(this.cpuParty);

                    System.out.println("Choose your target : ");
                    select = sc.nextLine();

                    if (select.equals("b")){
                        continue;
                    }

                    Hero enemy = listEnemy.get(Integer.parseInt(select) - 1);
                    if (!enemy.isDefeated()){
                        hero.normalAttack(enemy);
                        isTrue = false;
                    }else {
                        System.out.println("Sorry your target is already defeated, please choose another target!");
                    }
                } else if (select.equals("2")) {
                    display.listEnemy(this.cpuParty);
                    System.out.println("Choose your target : ");
                    select = sc.nextLine();

                    if (select.equals("b")){
                        continue;
                    }

                    Hero enemy = listEnemy.get(Integer.parseInt(select) - 1);
                    if (!enemy.isDefeated()){
                        hero.specialAttack(enemy);
                        isTrue = false;
                    }else {
                        System.out.println("Sorry your target is already defeated, please choose another target!");
                    }
                } else if (select.equals("3")) {
                    if (hero.getMana() < hero.getSkill1().getManaCost()){
                        System.out.println("Sorry your mana is not enough, please use another skill!");
                        continue;
                    }

                    if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ENEMY){
                        display.listEnemy(this.cpuParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ALLY) {
                        display.listAlly(this.playerParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.DEAD_ALLY) {
                        display.listDeadAlly(this.playerParty);
                    } else {
                        if (!cpuParty.isDefeated()){
                            hero.useSkill1(cpuParty.getCharacters());
                            isTrue = false;
                        }else {
                            System.out.println("Sorry your target team is already defeated, please choose another target!");
                        }
                    }

                    System.out.println("Choose your target : ");
                    select = sc.nextLine();

                    if (select.equals("b")){
                        continue;
                    }

                    Hero enemy = listEnemy.get(Integer.parseInt(select) - 1);
                    if (!enemy.isDefeated()){
                        hero.useSkill1(enemy);
                        isTrue = false;
                    }else {
                        System.out.println("Sorry your target is already defeated, please choose another target!");
                    }

                } else if (select.equals("4")) {
                    if (hero.getMana() < hero.getSkill1().getManaCost()){
                        System.out.println("Sorry your mana is not enough, please use another skill!");
                        continue;
                    }


                    if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ENEMY){
                        display.listEnemy(this.cpuParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ALLY) {
                        display.listAlly(this.playerParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.DEAD_ALLY) {
                        display.listDeadAlly(this.playerParty);
                    } else {
                        if (!cpuParty.isDefeated()){
                            hero.useSkill1(cpuParty.getCharacters());
                            isTrue = false;
                        }else {
                            System.out.println("Sorry your target team is already defeated, please choose another target!");
                        }
                    }

                    System.out.println("Choose your target : ");
                    select = sc.nextLine();

                    if (select.equals("b")){
                        continue;
                    }

                    Hero enemy = listEnemy.get(Integer.parseInt(select) - 1);
                    if (!enemy.isDefeated()){
                        hero.useSkill1(enemy);
                        isTrue = false;
                    }else {
                        System.out.println("Sorry your target is already defeated, please choose another target!");
                    }

                } else if (select.equals("b")){
                    continue;
                }
            }
            hero.setTurn(true);
        }
        resetHeroTurn(listHero);




    }


    private void playerTurn (){
        ArrayList<Hero> listHero = playerParty.getCharacters();
        ArrayList<Hero> listEnemy = cpuParty.getCharacters();

        while ((!listHero.get(0).isTurn() && !listHero.get(0).isDefeated()) || (!listHero.get(1).isTurn() && !listHero.get(1).isDefeated()) || (!listHero.get(2).isTurn() && !listHero.get(2).isDefeated())){
            System.out.println("Choose your hero  : ");
            String select = sc.nextLine();

            Hero hero = listHero.get(Integer.parseInt(select) - 1);

            if (hero.isTurn()){
                System.out.println("Please choose another hero, hero already used!");
                continue;
            }

            if (hero.hasSkill1()){
                display.hasSkill1(hero);
            } else if (hero.hasSkill2()) {
                display.hasSkill2(hero);
            }

            boolean isTrue = true;
            while (isTrue){
                System.out.println("Choose your skill : ");
                select = sc.nextLine();
                if (select.equals("1")){
                    display.listEnemy(this.cpuParty);

                    System.out.println("Choose your target : ");
                    select = sc.nextLine();

                    if (select.equals("b")){
                        continue;
                    }

                    Hero enemy = listEnemy.get(Integer.parseInt(select) - 1);
                    if (!enemy.isDefeated()){
                        hero.normalAttack(enemy);
                        isTrue = false;
                    }else {
                        System.out.println("Sorry your target is already defeated, please choose another target!");
                    }
                } else if (select.equals("2")) {
                    display.listEnemy(this.cpuParty);
                    System.out.println("Choose your target : ");
                    select = sc.nextLine();

                    if (select.equals("b")){
                        continue;
                    }

                    Hero enemy = listEnemy.get(Integer.parseInt(select) - 1);
                    if (!enemy.isDefeated()){
                        hero.specialAttack(enemy);
                        isTrue = false;
                    }else {
                        System.out.println("Sorry your target is already defeated, please choose another target!");
                    }
                } else if (select.equals("3")) {
                    if (hero.getMana() < hero.getSkill1().getManaCost()){
                        System.out.println("Sorry your mana is not enough, please use another skill!");
                        continue;
                    }

                    if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ENEMY){
                        display.listEnemy(this.cpuParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ALLY) {
                        display.listAlly(this.playerParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.DEAD_ALLY) {
                        display.listDeadAlly(this.playerParty);
                    } else {
                        if (!cpuParty.isDefeated()){
                            hero.useSkill1(cpuParty.getCharacters());
                            isTrue = false;
                        }else {
                            System.out.println("Sorry your target team is already defeated, please choose another target!");
                        }
                    }

                    System.out.println("Choose your target : ");
                    select = sc.nextLine();

                    if (select.equals("b")){
                        continue;
                    }

                    Hero enemy = listEnemy.get(Integer.parseInt(select) - 1);
                    if (!enemy.isDefeated()){
                        hero.useSkill1(enemy);
                        isTrue = false;
                    }else {
                        System.out.println("Sorry your target is already defeated, please choose another target!");
                    }

                } else if (select.equals("4")) {
                    if (hero.getMana() < hero.getSkill1().getManaCost()){
                        System.out.println("Sorry your mana is not enough, please use another skill!");
                        continue;
                    }


                    if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ENEMY){
                        display.listEnemy(this.cpuParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ALLY) {
                        display.listAlly(this.playerParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.DEAD_ALLY) {
                        display.listDeadAlly(this.playerParty);
                    } else {
                        if (!cpuParty.isDefeated()){
                            hero.useSkill1(cpuParty.getCharacters());
                            isTrue = false;
                        }else {
                            System.out.println("Sorry your target team is already defeated, please choose another target!");
                        }
                    }

                    System.out.println("Choose your target : ");
                    select = sc.nextLine();

                    if (select.equals("b")){
                        continue;
                    }

                    Hero enemy = listEnemy.get(Integer.parseInt(select) - 1);
                    if (!enemy.isDefeated()){
                        hero.useSkill1(enemy);
                        isTrue = false;
                    }else {
                        System.out.println("Sorry your target is already defeated, please choose another target!");
                    }

                } else if (select.equals("b")){
                    continue;
                }
            }
            hero.setTurn(true);
        }
        resetHeroTurn(listHero);
    }





    private void _createPartyForCPU (){
        ArrayList <Hero> listHeroes = new ArrayList<>();

        int i = 1;
        while (listHeroes.size() < 3){
            int rNum = random.nextInt(12);
            Hero result = selectHero(String.valueOf(rNum + 1));

            if (listHeroes.contains(result)){
                continue;
            }else {
                if (result != null){
                    listHeroes.add(result);
                    i++;
                }else {
                    continue;
                }
            }
        }
        this.cpuParty = createCPUParty("COM", listHeroes.get(0), listHeroes.get(1), listHeroes.get(2));
    }

    private Hero _createHero (){
        Hero hero = new Hero();

        display.createHero();
        display.element();


        String select = sc.nextLine();
        hero.setHeroElement(selectHeroElement(select));

        display.role();

        select = sc.nextLine();
        hero.setHeroRole(selectHeroRole(select));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           Hero Details                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Name      : ");
        String name = sc.nextLine(); hero.setName(name);
        System.out.print("HP        : ");
        String HP = sc.nextLine(); hero.setHP(Integer.parseInt(HP));
        System.out.print("ATK       : ");
        String ATK = sc.nextLine(); hero.setAttack(Integer.parseInt(ATK));
        System.out.print("DEF       : ");
        String DEF = sc.nextLine(); hero.setAttack(Integer.parseInt(DEF));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                            Hero SKills                            |");
        System.out.println("---------------------------------------------------------------------");
        display.listSkill();
        select = sc.nextLine();


        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           Let's Fight                             |");
        System.out.println("---------------------------------------------------------------------");

        return hero;
    }

    private Hero selectHero (String select) {
        Hero temp = null;

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
        } else if (select.equalsIgnoreCase("c")){
            temp = _createHero();
        }else {
            return null;
        }
        return temp;
    }

    private HeroElement selectHeroElement (String select){
        if (select.equals("a")){
            return HeroElement.FIRE;
        } else if (select.equals("b")) {
            return HeroElement.WATER;
        } else if (select.equals("c")) {
            return HeroElement.GRASS;
        }
        return null;
    }

    private HeroRole selectHeroRole (String select){
        if (select.equals("a")){
            return HeroRole.FIGHTER;
        } else if (select.equals("b")) {
            return HeroRole.TANK;
        } else if (select.equals("c")) {
            return HeroRole.ARCHER;
        } else if (select.equals("d")) {
            return HeroRole.SUPPORT;
        } else if (select.equals("e")) {
            return HeroRole.MAGE;
        }
        return null;
    }

    private void resetHeroTurn (ArrayList<Hero> listHero){
        listHero.get(0).setTurn(false);
        listHero.get(1).setTurn(false);
        listHero.get(2).setTurn(false);

    }
}
