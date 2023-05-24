

public class Display {
    void gameField (IParty playerParty, IParty cpuParty){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                      |    BRAWL HEROES     |                 [ X ]|");
        System.out.println("|===================================================================|");
        System.out.println("|                      |                     |                      |");
        System.out.println("|                      |                     |                      |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |                     |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|                     |----------------------| ");
        System.out.println("|      |       |       |                     |      |       |       |");
        System.out.println("|=======================                     =======================|");
        System.out.println("|                      |  ██    ██  ██████   |                      |");
        System.out.println("|                      |  ██    ██ ██        |                      |");
        System.out.println("|----------------------|   ██  ██   █████    |----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |    ████        ██   |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|     ██    ██████    |----------------------|");
        System.out.println("|      |       |       |                     |      |       |       | ");
        System.out.println("|=======================                     =======================|");
        System.out.println("|                      |                     |                      |");
        System.out.println("|                      |                     |                      |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |                     |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|                     |----------------------| ");
        System.out.println("|      |       |       |                     |      |       |       |");
        System.out.println("---------------------------------------------------------------------");
    }

    void winnerBanner (){
        System.out.println("          ██        ██ ██ ███   ██ ███   ██ ███████ ██████           ");
        System.out.println("          ██   ██   ██ ██ ████  ██ ████  ██ ██      ██   ██          ");
        System.out.println("           ██ ████ ██  ██ ██ ██ ██ ██ ██ ██ █████   ██████           ");
        System.out.println("           ████  ████  ██ ██  ████ ██  ████ ██      ██   ██          ");
        System.out.println("            ██    ██   ██ ██   ███ ██   ███ ███████ ██   ██          ");
        System.out.println("                                                                     ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|                            TEAM NAME                               |");
        System.out.println("|====================================================================|");
        System.out.println("|                      |                      |                      |");
        System.out.println("|                      |                      |                      |");
        System.out.println("|----------------------|----------------------|----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |  HP  |  DEF  |  ATK  |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|----------------------|----------------------|");
        System.out.println("|      |       |       |      |       |       |      |       |       |");
        System.out.println("|====================================================================|");
    }



    void menuGame (){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                                Menu                               |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           [a] New Game                            |");
        System.out.println("|                           [b] Load Game                           |");
        System.out.println("|                           [c] Exit Game                           |");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                         Select (a | b | c)                        |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void newGameMenu (){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                              Options                              |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           [a] Create Party                        |");
        System.out.println("|                           [b] Back                                |");
        System.out.println("|                                                                   |");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                         Select (a | b | c)                        |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void readyGameDisplay (IParty playerParty) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|                            TEAM NAME                               |");
        System.out.println("|====================================================================|");
        System.out.println("|                      |                      |                      |");
        System.out.println("|                      |                      |                      |");
        System.out.println("|----------------------|----------------------|----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |  HP  |  DEF  |  ATK  |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|----------------------|----------------------|");
        System.out.println("|      |       |       |      |       |       |      |       |       |");
        System.out.println("|====================================================================|");
        System.out.println("|                         Start play (Y/n) ?                         |");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void menuGameWhenPlay (){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                              Options                              | ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           [a] Continue                            |");
        System.out.println("|                           [b] Quit Game                           |");
        System.out.println("|                                                                   |");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           Select (a | b)                          |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void validateQuitGame (){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                     Are you sure to quit game ?                   |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        [a] Yes (save game)                        |");
        System.out.println("|                        [b] Yes (not save)                         |");
        System.out.println("|                        [c] No                                     |");
        System.out.println("|                                                                   |");
        System.out.println("|                           Swift Games                             |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (a | b | c)                         |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void listHero (){
        System.out.println("                       !Select Your 3 Heroes!                       ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                            LIST HERO                              |");
        System.out.println("|===================================================================|");
        System.out.println("|         Fire         |        Grass        |        Water         |");
        System.out.println("|===================================================================|");
        System.out.println("| [1] Murby  | Fighter | [5] Greysn| Tank    | [9]  Theseus| Tank   |");
        System.out.println("| [2] Helda  | Tank    | [6] Elisa | Mage    | [10] Atla   | Archer |");
        System.out.println("| [3] Veldora| Mage    | [7] Lily  | Archer  | [11] Pomi   | Support|");
        System.out.println("| [4] Deus   | Archer  | [8] Fara  | Support | [12] Marie  | Fighter|");
        System.out.println("|                      |                     |                      |");
        System.out.println("|===================================================================|");
        System.out.println("| [c] Create Hero                                                   |");
        System.out.println("|===================================================================|");
        System.out.print("Your Choice : ");
    }

    void createTeam(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                   Are you ready for the challenge ?               |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Enter your name party : ");
    }

    void brawlHeroes (){
        System.out.println("░█▀▀█ ░█▀▀█ ─█▀▀█ ░█──░█ ░█─── 　 ░█─░█ ░█▀▀▀ ░█▀▀█ ░█▀▀▀█ ░█▀▀▀ ░█▀▀▀█ ");
        System.out.println("░█▀▀▄ ░█▄▄▀ ░█▄▄█ ░█░█░█ ░█─── 　 ░█▀▀█ ░█▀▀▀ ░█▄▄▀ ░█──░█ ░█▀▀▀ ─▀▀▀▄▄ ");
        System.out.println("░█▄▄█ ░█─░█ ░█─░█ ░█▄▀▄█ ░█▄▄█ 　 ░█─░█ ░█▄▄▄ ░█─░█ ░█▄▄▄█ ░█▄▄▄ ░█▄▄▄█ ");
        System.out.println();
        System.out.println("               Unleash Your Team's Might in Brawl Heroes               ");
        System.out.println("                    Triumph in Turn-based Battles!                     ");
        System.out.println();
    }
}
