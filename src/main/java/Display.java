

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
        System.out.println("|                               Menu                                |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           [a] New Game                            |");
        System.out.println("|                           [b] Load Game                           |");
        System.out.println("|                           [c] Exit Game                           |");
        System.out.println("|                                                                   |");
        System.out.println("|                             Swift Game                            |");
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
        System.out.println("|                           [b] Create Hero                         |");
        System.out.println("|                           [c] Back                                |");
        System.out.println("|                                                                   |");
        System.out.println("|                             Swift Game                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                         Select (a | b | c)                        |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void readyGameDisplay () {
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
        System.out.println("|                             Swift Game                            |");
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
        System.out.println("|                            Swift Game                             |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (a | b | c)                         |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void listHero (){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                            LIST HERO                              |");
        System.out.println("|===================================================================|");
        System.out.println("|         Fire         |        Water        |        Grass         |");
        System.out.println("|===================================================================|");
        System.out.println("|                      |                     |                      |");
        System.out.println("|                      |                     |                      |");
        System.out.println("|                      |                     |                      |");
        System.out.println("|                      |                     |                      |");
        System.out.println("|                      |                     |                      |");
        System.out.println("|===================================================================|");
        System.out.print("Your Choice : ");
    }

    void createTeam(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                   Are you ready for the challenge ?               |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Enter your name party : ");
    }
}
