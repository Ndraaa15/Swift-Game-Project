import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


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
        String path1 = "C:\\Users\\indra\\Documents\\Developments\\Java\\Object Oriented Progamming\\Swift-Game\\src\\main\\resources\\playerDB.json";
        String path2 = "C:\\Users\\indra\\Documents\\Developments\\Java\\Object Oriented Progamming\\Swift-Game\\src\\main\\resources\\comDB.json";
       Gson gson = new GsonBuilder()
               .setPrettyPrinting()
               .create();
       try (FileWriter writer1 = new FileWriter(path1)){
           gson.toJson(this.playerParty, writer1);

       }catch (IOException e){
           throw new RuntimeException(e);
       }

       try ( FileWriter writer2 = new FileWriter(path2)){
           gson.toJson(this.cpuParty, writer2);

       }catch (IOException e){
           throw new RuntimeException(e);
       }

       display.thankYou();
       _exitGame();

    }

    @Override
    public void loadGame() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String path1 = "C:\\Users\\indra\\Documents\\Developments\\Java\\Object Oriented Progamming\\Swift-Game\\src\\main\\resources\\playerDB.json";
        String path2 = "C:\\Users\\indra\\Documents\\Developments\\Java\\Object Oriented Progamming\\Swift-Game\\src\\main\\resources\\comDB.json";
        try {
            FileReader reader1 = new FileReader(path1);
            Type playerPartyToken = new TypeToken<Party>(){}.getType();

            this.playerParty = gson.fromJson(reader1, playerPartyToken);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        try {
            FileReader reader2 = new FileReader(path2);
            Type cpuPartyToken = new TypeToken<Party>(){}.getType();

            this.cpuParty = gson.fromJson(reader2, cpuPartyToken);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        display.readyGameDisplay(this.playerParty);
        String select = sc.nextLine();
        boolean isTrue = true;
        do {
            switch (select) {
                case "y" -> {
                    isTrue = false;
                    gameON();
                }
                case "n" -> {
                    start();
                }
                default -> System.out.println("Please choose between ( y | n ) !!!");
            }
        }while (isTrue);
    }

    @Override
    public IParty nextTurn() {
        return null;
    }

    @Override
    public IParty winner() {
        if (this.playerParty.isDefeated()){
            return this.cpuParty;
        }else {
            return this.playerParty;
        }
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
                    loadGame();
                }
                case "c" -> {
                    heroesPedia();
                }
                case "d" -> {
                    isTrue = false;
                    _exitGame();
                }
                default -> {
                    System.out.println("Please choose between ( a | b | c ) !!!");
                    System.out.print("Your Choice : ");
                }
            }
        }

    }


    private void heroesPedia () {
        display.heroespedia();

        while (true) {
            String select = sc.nextLine();
            if (select.equals("b")) {
                start();
            } else {
                System.out.println("Please choose ( b ) !!!");
                System.out.print("Your Choice : ");
            }
        }
    }

    private void _newGame (){
        display.newGameMenu();
        boolean isTrue = true;
        while (isTrue){
            String select = sc.nextLine();
            switch (select) {
                case "a" -> {
                    isTrue = false;
                    _createPartyForPlayer();
                }
                case "b" -> {
                    isTrue = false;
                    start();
                }
                default -> {
                    System.out.println("Please choose between ( a | b ) !!!");
                    System.out.print("Your Choice : ");
                }
            }
        }
    }


    private void _exitGame (){
        System.exit(0);
    }

    private void _createPartyForPlayer (){
        display.createTeam();

        String partyName = sc.nextLine();
        if (partyName.length() > 10){
            System.out.println("Your team name should be less than 10 letters");
            _createPartyForPlayer();
        }
        display.listHero();

        ArrayList <Hero> listHeroes = new ArrayList<>();

        int i = 1;
        while (listHeroes.size() < 3){
            System.out.print("Heroes " + (i) + " : ");
            String select = sc.nextLine();

            Hero result = selectHero(select);

            if (listHeroes.contains(result)){
                System.out.println("---------------------------------------------------------------------");
                System.out.println("|        Hero already selected, please select another hero!         |");
                System.out.println("---------------------------------------------------------------------");
            }else {
                if (result != null){
                    listHeroes.add(result);
                    heroes.useHero(result.getName());
                    int l = result.getName().length() + 20;
                    int r = 47 - l;
                    System.out.println("---------------------------------------------------------------------");
                    System.out.printf("|%" + l  + "s Added to Team Party %" + r +  "s\n", result.getName(), "|");
                    System.out.println("---------------------------------------------------------------------");
                    i++;
                }else {
                    System.out.println("Please choose heroes between 1 - 12 or 'c' to create hero!");
                }
            }
        }

        this.playerParty = createPlayerParty(partyName, listHeroes.get(0), listHeroes.get(1), listHeroes.get(2));

        display.readyGameDisplay(this.playerParty);

        boolean isTrue = true;
        while (isTrue){
            String select = sc.nextLine();

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
                default -> {
                    System.out.println("Please choose between ( y | n ) !!!");
                    System.out.print("Your Choice : ");
                }
            }
        };
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
                if (result != null && !heroes.isUsed(result.getName())){
                    listHeroes.add(result);
                    i++;
                }else {
                    continue;
                }
            }
        }
        this.cpuParty = createCPUParty("COM", listHeroes.get(0), listHeroes.get(1), listHeroes.get(2));
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
            display.gameField(this.playerParty, this.cpuParty);
        }

        IParty winnerTeam = winner();
        if (winnerTeam != null){
            display.winnerBanner(winnerTeam);
        }

        display.playAgainOrNo();

        while (true){
            String select = sc.nextLine();

            if (select.equals("y")){
                start();
            } else if (select.equals("n")) {
                display.thankYou();
                _exitGame();
            }else {
                System.out.println("Please choose between ( y | n ) !!!");
            }
        }
    }

    private void cpuTurn(){
        ArrayList<Hero> listHero = playerParty.getCharacters();
        ArrayList<Hero> listEnemy = cpuParty.getCharacters();
        int i = 0;
        int select = 0;

        while ((!listEnemy.get(0).isTurn() && !listEnemy.get(0).isDefeated()) || (!listEnemy.get(1).isTurn() && !listEnemy.get(1).isDefeated()) || (!listEnemy.get(2).isTurn() && !listEnemy.get(2).isDefeated())){
            Hero hero = listEnemy.get(i);

            if (hero.isTurn() || hero.isDefeated()){
                i++;
                continue;
            }

            boolean isTrue = true;
            while (isTrue){
                if (hero.hasSkill1()){
                    if (hero.getMana() < hero.getSkill1().getManaCost()){
                        select = random.nextInt(2);
                    }else {
                        select = random.nextInt(3);
                    }
                } else if (hero.hasSkill2()) {
                    if ((hero.getMana() < hero.getSkill1().getManaCost()) && (hero.getMana() < hero.getSkill2().getManaCost())){
                        select = random.nextInt(2);
                    } else{
                        select = random.nextInt(4);
                    }
                }

                String strRand = String.valueOf(select + 1);

                if (strRand.equals("1")){

                    int rAlgo = cpuAlgorihtm(listHero);

                    Hero enemy = listHero.get(rAlgo);

                    if (!enemy.isDefeated()){
                        hero.normalAttack(enemy);
                        isTrue = false;
                    }else {

                    }
                } else if (strRand.equals("2")) {

                    int rAlgo = cpuAlgorihtm(listHero);
                    Hero enemy = listHero.get(rAlgo);

                    if (!enemy.isDefeated()){
                        hero.specialAttack(enemy);
                        isTrue = false;
                    }else {

                    }

                } else if (strRand.equals("3")) {

                    if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ENEMY){
                        select = cpuAlgorihtm(listHero);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ALLY) {
                        select = cpuAlgorihtm(listEnemy);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.DEAD_ALLY) {
                        select = cpuAlgorihtmDeadAlly(listEnemy);
                        if (select == -1){
                            continue;
                        }
                    } else if (hero.getSkill1().getTarget() == SkillTarget.ALL_ENEMY){
                        if (!this.playerParty.isDefeated()){
                            hero.useSkill1(playerParty.getCharacters());
                            break;
                        }else {

                        }
                        continue;
                    } else if (hero.getSkill1().getTarget() == SkillTarget.ALL_ALLY) {
                        if (!this.cpuParty.isDefeated()){
                            hero.useSkill1(cpuParty.getCharacters());
                            break;
                        }else {

                        }
                        continue;
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SELF) {
                        if (!hero.isDefeated()){
                            hero.useSkill1(hero);
                            break;
                        }else {

                        }
                        continue;
                    }

                    Hero player = listHero.get(select);
                    if (!player.isDefeated()){
                        hero.useSkill1(player);
                        isTrue = false;
                    }else {

                    }

                } else if (strRand.equals("4")) {

                    if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ENEMY){
                        select = cpuAlgorihtm(listHero);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SINGLE_ALLY) {
                        select = cpuAlgorihtm(listEnemy);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.DEAD_ALLY) {
                        select = cpuAlgorihtmDeadAlly(listEnemy);
                        if (select == -1){
                            continue;
                        }
                    } else if (hero.getSkill1().getTarget() == SkillTarget.ALL_ENEMY){
                        if (!this.playerParty.isDefeated()){
                            hero.useSkill1(playerParty.getCharacters());
                            break;
                        }else {

                        }
                        continue;
                    } else if (hero.getSkill1().getTarget() == SkillTarget.ALL_ALLY) {
                        if (!this.cpuParty.isDefeated()){
                            hero.useSkill1(cpuParty.getCharacters());
                            break;
                        }else {

                        }
                        continue;
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SELF) {
                        if (!hero.isDefeated()){
                            hero.useSkill1(hero);
                            break;
                        }else {

                        }
                        continue;
                    }

                    Hero enemy = listHero.get(select);
                    if (!enemy.isDefeated()){
                        hero.useSkill1(enemy);
                        isTrue = false;
                    }else {

                    }
                }
            }
            i++;
            hero.setTurn(true);
        }
        decreamentEffect(listEnemy);
        resetHeroTurn(listEnemy);
    }


    private void playerTurn (){
        ArrayList<Hero> listHero = playerParty.getCharacters();
        ArrayList<Hero> listEnemy = cpuParty.getCharacters();

        while ((!listHero.get(0).isTurn() && !listHero.get(0).isDefeated()) || (!listHero.get(1).isTurn() && !listHero.get(1).isDefeated()) || (!listHero.get(2).isTurn() && !listHero.get(2).isDefeated())){
            System.out.print("Choose your hero  : ");
            String select = sc.nextLine();

            if (select.equals("x")){
                display.menuGameWhenPlay();
                select = sc.nextLine();
                if (select.equals("b")){
                    int result = _exitGameWhenPlay();
                    if (result == 1){
                        saveGame();
                    } else if (result == 2) {
                        _exitGame();
                    } else {
                        continue;
                    }
                }else {
                    continue;
                }
            }

            Hero hero = listHero.get(Integer.parseInt(select) - 1);

            if (hero.isTurn()){
                System.out.println("Please choose another hero, hero already used!");
                continue;
            } else if (hero.isDefeated()){
                System.out.println("Please choose another hero, hero already defeated!");
                continue;
            }

            if (hero.hasSkill1()){
                display.hasSkill1(hero);
            } else if (hero.hasSkill2()) {
                display.hasSkill2(hero);
            }

            boolean isTrue = true;
            while (isTrue){
                System.out.print("Choose your skill : ");
                select = sc.nextLine();
                if (select.equals("1")){
                    display.listEnemy(this.cpuParty);

                    System.out.print("Choose your target : ");
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
                    System.out.print("Choose your target : ");
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
                        display.listAlly(this.playerParty, hero.getName());
                    } else if (hero.getSkill1().getTarget() == SkillTarget.DEAD_ALLY) {
                        display.listDeadAlly(this.playerParty);
                    } else if (hero.getSkill1().getTarget() == SkillTarget.ALL_ENEMY){
                        if (!this.cpuParty.isDefeated()){
                            hero.useSkill1(cpuParty.getCharacters());
                            break;
                        }else {
                            System.out.println("Sorry your target team is already defeated, please choose another target!");
                        }
                        continue;
                    } else if (hero.getSkill1().getTarget() == SkillTarget.ALL_ALLY) {
                        if (!this.playerParty.isDefeated()){
                            hero.useSkill1(cpuParty.getCharacters());
                            break;
                        }else {
                            System.out.println("Sorry your target team is already defeated, please choose another target!");
                        }
                        continue;
                    } else if (hero.getSkill1().getTarget() == SkillTarget.SELF) {
                        if (!hero.isDefeated()){
                            hero.useSkill1(hero);
                            break;
                        }else {
                            System.out.println("Sorry your target hero is already defeated, please choose another target!");
                        }
                        continue;
                    }

                    System.out.print("Choose your target : ");
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
                        display.listAlly(this.playerParty, hero.getName());
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

                    System.out.print("Choose your target : ");
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
        decreamentEffect(listHero);
        resetHeroTurn(listHero);
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
        display.skillList();
        for (int i = 0; i < 2; i++) {
            System.out.print("Choose favourite skill" + (i + 1) + " : ");
            select = sc.nextLine();
            Skill skill = BaseGameSkills.getSkill(Integer.parseInt(select) - 1);
            if (i == 0){
                hero.setSkill1(skill);
            }else {
                hero.setSkill2(skill);
            }
        }


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
            temp = heroes.getHero("Veld");
        } else if (select.equals("4")){
            temp = heroes.getHero("Deus");
        } else if (select.equals("5")){
            temp = heroes.getHero("Grove");
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
            temp = heroes.getHero("Marie");
        } else if (select.equals("12")){
            temp = heroes.getHero("Dillo");
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

    private int cpuAlgorihtm (ArrayList <Hero> playerParty){
        int i = 0;

        for (int j = 1; j < playerParty.size(); j++) {
            if (playerParty.get(i).getHP() >=  playerParty.get(j).getHP() && (!playerParty.get(j).isDefeated())){

                i = j;
                break;

            }
        }
        return i;
    }

    private int cpuAlgorihtmDeadAlly (ArrayList <Hero> cpuParty){
         int i = -1;
        for (int j = 1; j < cpuParty.size(); j++) {
            if (cpuParty.get(j).isDefeated()){
                i = j;
                break;
            }
        }
        return i;
    }

    private int _exitGameWhenPlay (){
        display.validateQuitGame();

        while (true){
            String select = sc.nextLine();
            if (select.equals("a")){
                return 1;
            } else if (select.equals("b")) {
                return 2;
            } else if (select.equals("c")){
                return 3;
            }else {
                System.out.println("Please choose between ( a | b | c ) !!!");
            }
        }
    }

    private void decreamentEffect (ArrayList<Hero> listHero){
        for (Hero hero : listHero) {
            if (!hero.isDefeated()) {
                hero.getEffect().decrementAll();
            }
        }
    }
}
