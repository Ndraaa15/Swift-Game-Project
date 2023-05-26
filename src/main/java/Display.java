

public class Display {
    void gameField (IParty playerParty, IParty cpuParty){
        String team = playerParty.getPartyName() + "'s Team";
        int x = 5 + team.length();
        int y = 23 - x;

        //Player
        Hero h1 = playerParty.getCharacters().get(0);Hero h2 = playerParty.getCharacters().get(1);Hero h3 = playerParty.getCharacters().get(2);
        //Hero 1
        String hPla1 = h1.getName();
        int hPla1l = hPla1.length() + 8; int hPla1r = 23 - hPla1l;

        String atrH1 = h1.getHeroElement().toString() + " | " +h1.getHeroRole().toString();
        int atrH1l = atrH1.length() + 4; int atrH1r = 23 - atrH1l;

        //Hero 2
        String hPla2 = h2.getName();
        int hPla2l = hPla1.length() + 8; int hPla2r = 23 - hPla1l;

        String atrH2 = h2.getHeroElement().toString() + " | " +h2.getHeroRole().toString();
        int atrH2l = atrH2.length() + 4; int atrH2r = 23 - atrH2l;


        //Hero 3
        String hPla3 = h3.getName();
        int hPla3l = hPla3.length() + 8; int hPla3r = 23 - hPla3l;

        String atrH3 = h3.getHeroElement().toString() + " | " +h3.getHeroRole().toString();
        int atrH3l = atrH3.length() + 4; int atrH3r = 23 - atrH3l;


//        int hp1 = playerParty.getCharacters().get(0).getHP();int hp2 = playerParty.getCharacters().get(1).getHP();int hp3 = playerParty.getCharacters().get(2).getHP();
//        int hpsl1 = 2 + String.valueOf(hp1).length();
//        int hpsr1 = 6 - hpl1 + 1;
//
//        int hp13123l2 = 2 + String.valueOf(hp2).length();
//        int hpr1231232 = 6 - hpl2 + 1;
//
//        int hpl21313 = 2 + String.valueOf(hp3).length();
//        int f123 = 6 - hpl2 + 1;


        int def1 = playerParty.getCharacters().get(0).getHP();int def2 = playerParty.getCharacters().get(1).getHP();int def3 = playerParty.getCharacters().get(2).getHP();

        int defl1 = 2 + String.valueOf(def1).length();
        int defr1 = 6 - defl1 + 1;

        int defl2 = 2 + String.valueOf(def2).length();
        int defr2 = 6 - defl2 + 1;

        int defl3 = 2 + String.valueOf(def3).length();
        int defr3 = 6 - defl3 + 1;


        int atk1 = playerParty.getCharacters().get(0).getHP();int atk2 = playerParty.getCharacters().get(1).getHP();int atk3 = playerParty.getCharacters().get(2).getHP();

        int atkl1 = 2 + String.valueOf(atk1).length();
        int atkr1 = 6 - atkl1 + 1;

        int atkl2 = 2 + String.valueOf(atk2).length();
        int atkr2 = 6 - atkl2 + 1;

        int atkl3 = 2 + String.valueOf(atk3).length();
        int atkr3 = 6 - atkl3 + 1;





        //Enemy
        Hero e1 = cpuParty.getCharacters().get(0);Hero e2 = cpuParty.getCharacters().get(1);Hero e3 = cpuParty.getCharacters().get(2);
        //Enemy 1
        String hE1 = e1.getName();
        int hE1l = hE1.length() + 8; int hE1r = 23 - hE1l;

        String atrE1 = e1.getHeroElement().toString() + " | " +e1.getHeroRole().toString();
        int atrE1l = atrE1.length() + 4; int atrE1r = 23 - atrE1l;

        //Enemy 2
        String hE2 = e2.getName();
        int hE2l = hE2.length() + 8; int hE2r = 23 - hE2l;

        String atrE2 = e2.getHeroElement().toString() + " | " +e2.getHeroRole().toString();
        int atrE2l = atrE2.length() + 4; int atrE2r = 23 - atrE2l;

        //Enemy 3
        String hE3 = e3.getName();
        int hE3l = hE2.length() + 8; int hE3r = 23 - hE3l;

        String atrE3 = e3.getHeroElement().toString() + " | " +e3.getHeroRole().toString();
        int atrE3l = atrE3.length() + 4; int atrE3r = 23 - atrE3l;



        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("|%" + x + "s%" + y + "s    BRAWL HEROES     |         COM     [ X ]|\n", team, "|");
        System.out.println("|===================================================================|");
        System.out.println("|          1           |                     |          1           |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.printf("|%" + hPla1l + "s%" + hPla1r + "s                     |%" + hE1l + "s%" + hE1r + "s\n", hPla1, "|", hE1, "|"); // Name
        System.out.printf("|%" + atrH1l + "s%" + atrH1r + "s                     |%" + atrE1l + "s%" + atrE1r + "s\n", atrH1, "|", atrE1, "|"); //element | role
        System.out.println("|                      |                     |                      |"); // Effect
        System.out.println("|----------------------|                     |----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |                     |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|                     |----------------------| ");
        System.out.println("|      |       |       |                     |      |       |       |");
        System.out.println("|=======================                     =======================|");
        System.out.println("|          2           |                     |          2           |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.printf("|%" + hPla2l + "s%" + hPla2r + "s  ██      ██ ██████  |%" + hE2l + "s%" + hE2r +  "s\n", hPla2, "|", hE2, "|");
        System.out.printf("|%" + atrH2l + "s%" + atrH2r + "s   ██    ██ ██       |%" + atrE2l + "s%" + atrE2r + "s\n", atrH2, "|", atrE2, "|");
        System.out.println("|                      |    ██  ██   █████   |                      |");
        System.out.println("|----------------------|     ████        ██  |----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |      ██    ██████   |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.println("|      |       |       |                     |      |       |       | ");
        System.out.println("|=======================                     =======================|");
        System.out.println("|          3           |                     |          3           |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.printf("|%" + hPla3l + "s%" + hPla3r + "s                     |%" + hE3l + "s%" + hE3r + "s\n", hPla3, "|", hE3, "|"); // Name
        System.out.printf("|%" + atrH3l + "s%" + atrH3r + "s                     |%" + atrE3l + "s%" + atrE3r + "s\n", atrH3, "|", atrE3, "|"); //element | role
        System.out.println("|                      |                     |                      |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |                     |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|                     |----------------------| ");
        System.out.println("|      |       |       |                     |      |       |       |");
        System.out.println("---------------------------------------------------------------------");
    }

    void winnerBanner (IParty winnerTeam){
        String team = winnerTeam.getPartyName() + "'s Team";
        int x = team.length() + 28;
        int y = 68 - x + 1;

        String h1 = winnerTeam.getCharacters().get(0).getName();String h2 = winnerTeam.getCharacters().get(1).getName();String h3 = winnerTeam.getCharacters().get(2).getName();
        int hl1 = 7 + h1.length()+1;
        int hr1 = 22 - hl1 + 1;

        int hl2 = 7 + h2.length();
        int hr2 = 22 - hl2 + 1;

        int hl3 = 7 + h3.length();
        int hr3 = 22 - hl3 + 1;


        int hp1 = winnerTeam.getCharacters().get(0).getHP();int hp2 = winnerTeam.getCharacters().get(1).getHP();int hp3 = winnerTeam.getCharacters().get(2).getHP();
        int hpl1 = 2 + String.valueOf(hp1).length();
        int hpr1 = 6 - hpl1 + 1;

        int hpl2 = 2 + String.valueOf(hp2).length();
        int hpr2 = 6 - hpl2 + 1;

        int hpl3 = 2 + String.valueOf(hp3).length();
        int hpr3 = 6 - hpl2 + 1;


        int def1 = winnerTeam.getCharacters().get(0).getHP();int def2 = winnerTeam.getCharacters().get(1).getHP();int def3 = winnerTeam.getCharacters().get(2).getHP();

        int defl1 = 2 + String.valueOf(def1).length();
        int defr1 = 6 - defl1 + 1;

        int defl2 = 2 + String.valueOf(def2).length();
        int defr2 = 6 - defl2 + 1;

        int defl3 = 2 + String.valueOf(def3).length();
        int defr3 = 6 - defl3 + 1;


        int atk1 = winnerTeam.getCharacters().get(0).getHP();int atk2 = winnerTeam.getCharacters().get(1).getHP();int atk3 = winnerTeam.getCharacters().get(2).getHP();

        int atkl1 = 2 + String.valueOf(atk1).length();
        int atkr1 = 6 - atkl1 + 1;

        int atkl2 = 2 + String.valueOf(atk2).length();
        int atkr2 = 6 - atkl2 + 1;

        int atkl3 = 2 + String.valueOf(atk3).length();
        int atkr3 = 6 - atkl3 + 1;

        System.out.println();
        System.out.println("          ██        ██ ██ ███   ██ ███   ██ ███████ ██████           ");
        System.out.println("          ██   ██   ██ ██ ████  ██ ████  ██ ██      ██   ██          ");
        System.out.println("           ██ ████ ██  ██ ██ ██ ██ ██ ██ ██ █████   ██████           ");
        System.out.println("           ████  ████  ██ ██  ████ ██  ████ ██      ██   ██          ");
        System.out.println("            ██    ██   ██ ██   ███ ██   ███ ███████ ██   ██          ");
        System.out.println("                                                                     ");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("|%"+ x +"s" +"%" + y +"s\n"  , team, "|");
        System.out.println("|====================================================================|");
        System.out.printf("|%" + hl1 + "s%" + hr1 + "s%" + hl2 + "s%" + hr2 + "s%" + hl3 + "s%" + hr3 + "s\n", h1, "|", h2, "|", h3, "|");
        System.out.println("|                      |                      |                      |");
        System.out.println("|----------------------|----------------------|----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |  HP  |  DEF  |  ATK  |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|----------------------|----------------------|");
        System.out.printf("|%" + hpl1 + "s%" + hpr1 + "s%" + defl1 + "s %" + defr1 + "s%" + atkl1 + "s %" + atkr1 + "s%" + hpl2 + "s%" + hpr2 + "s%" + defl2 + "s %" + defr2 + "s%" + atkl2 + "s %" + atkr2 + "s%" + hpl3 + "s%" + hpr3 + "s%" + defl3 + "s %" + defr3 + "s%" + atkl3 + "s %" + atkr3 + "s\n", hp1, "|", def1, "|", atk1, "|", hp2, "|", def2, "|", atk2, "|", hp3, "|", def3, "|", atk3, "|");
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
        String team = playerParty.getPartyName() + "'s Team";
        int x = team.length() + 28;
        int y = 68 - x + 1;

        String h1 = playerParty.getCharacters().get(0).getName();String h2 = playerParty.getCharacters().get(1).getName();String h3 = playerParty.getCharacters().get(2).getName();
        int hl1 = 7 + h1.length()+1;
        int hr1 = 22 - hl1 + 1;

        int hl2 = 7 + h2.length();
        int hr2 = 22 - hl2 + 1;

        int hl3 = 7 + h3.length();
        int hr3 = 22 - hl3 + 1;


        int hp1 = playerParty.getCharacters().get(0).getHP();int hp2 = playerParty.getCharacters().get(1).getHP();int hp3 = playerParty.getCharacters().get(2).getHP();
        int hpl1 = 2 + String.valueOf(hp1).length();
        int hpr1 = 6 - hpl1 + 1;

        int hpl2 = 2 + String.valueOf(hp2).length();
        int hpr2 = 6 - hpl2 + 1;

        int hpl3 = 2 + String.valueOf(hp3).length();
        int hpr3 = 6 - hpl2 + 1;


        int def1 = playerParty.getCharacters().get(0).getHP();int def2 = playerParty.getCharacters().get(1).getHP();int def3 = playerParty.getCharacters().get(2).getHP();

        int defl1 = 2 + String.valueOf(def1).length();
        int defr1 = 6 - defl1 + 1;

        int defl2 = 2 + String.valueOf(def2).length();
        int defr2 = 6 - defl2 + 1;

        int defl3 = 2 + String.valueOf(def3).length();
        int defr3 = 6 - defl3 + 1;


        int atk1 = playerParty.getCharacters().get(0).getHP();int atk2 = playerParty.getCharacters().get(1).getHP();int atk3 = playerParty.getCharacters().get(2).getHP();

        int atkl1 = 2 + String.valueOf(atk1).length();
        int atkr1 = 6 - atkl1 + 1;

        int atkl2 = 2 + String.valueOf(atk2).length();
        int atkr2 = 6 - atkl2 + 1;

        int atkl3 = 2 + String.valueOf(atk3).length();
        int atkr3 = 6 - atkl3 + 1;


        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("|%"+ x +"s" +"%" + y +"s\n"  , team, "|");
        System.out.println("|====================================================================|");
        System.out.printf("|%" + hl1 + "s%" + hr1 + "s%" + hl2 + "s%" + hr2 + "s%" + hl3 + "s%" + hr3 + "s\n", h1, "|", h2, "|", h3, "|");
        System.out.println("|                      |                      |                      |");
        System.out.println("|----------------------|----------------------|----------------------|");
        System.out.println("|  HP  |  DEF  |  ATK  |  HP  |  DEF  |  ATK  |  HP  |  DEF  |  ATK  |");
        System.out.println("|----------------------|----------------------|----------------------|");
        System.out.printf("|%" + hpl1 + "s%" + hpr1 + "s%" + defl1 + "s %" + defr1 + "s%" + atkl1 + "s %" + atkr1 + "s%" + hpl2 + "s%" + hpr2 + "s%" + defl2 + "s %" + defr2 + "s%" + atkl2 + "s %" + atkr2 + "s%" + hpl3 + "s%" + hpr3 + "s%" + defl3 + "s %" + defr3 + "s%" + atkl3 + "s %" + atkr3 + "s\n", hp1, "|", def1, "|", atk1, "|", hp2, "|", def2, "|", atk2, "|", hp3, "|", def3, "|", atk3, "|");
        System.out.println("|====================================================================|");
        System.out.println("|                         Start play (y/n) ?                         |");
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
        System.out.println();
        System.out.println("                       !Select Your 3 Heroes!                       ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                            LIST HERO                              |");
        System.out.println("|===================================================================|");
        System.out.println("|         Fire         |        Grass        |        Water         |");
        System.out.println("|===================================================================|");
        System.out.println("| [1] Murby  | Fighter | [5] Greysn| Tank    | [9]  Theseus| Tank   |");
        System.out.println("| [2] Helda  | Tank    | [6] Elisa | Mage    | [10] Atla   | Archer |");
        System.out.println("| [3] Veldora| Mage    | [7] Lily  | Archer  | [11] Pomi   | Support|");
        System.out.println("| [4] Deus   | Archer  | [8] Fara  | Support | [12] Dillo  | Fighter|");
        System.out.println("|                      |                     |                      |");
        System.out.println("|===================================================================|");
        System.out.println("| [c] Create Hero                                                   |");
        System.out.println("|===================================================================|");
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

    void createHero(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           Create a Hero                           |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("          Unleash your imagination and forge an extraordinary        ");
        System.out.println("                          hero from scratch!                         ");
        System.out.println();
    }

    void element (){
        System.out.println("                       Choose your hero element                      ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                              Element                              |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             [a] Fire                              |");
        System.out.println("|                             [b] Water                             |");
        System.out.println("|                             [c] Grass                             |");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (a | b | c)                         |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void role (){
        System.out.println("                       Choose your role hero                        ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                               Role                                |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           [a] Fighter                             |");
        System.out.println("|                           [b] Tank                                |");
        System.out.println("|                           [c] Archer                              |");
        System.out.println("|                           [d] Support                             |");
        System.out.println("|                           [e] Mage                                |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                    Select (a | b | c | d | e)                     |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void listAlly (IParty playerParty){
        String h1 = playerParty.getCharacters().get(0).getName();String h2 = playerParty.getCharacters().get(1).getName();String h3 = playerParty.getCharacters().get(2).getName();
        int hl1 = 7 + h1.length()+1;
        int hr1 = 22 - hl1 + 1;

        int hl2 = 7 + h2.length();
        int hr2 = 22 - hl2 + 1;

        int hl3 = 7 + h3.length();
        int hr3 = 22 - hl3 + 1;

        System.out.println("                       Choose your target hero                      ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             List Ally                             |");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("|                          [1] %"+ hl1 + "s%" + hr1 + "s\n", h1, "|");
        System.out.printf("|                          [2] %"+ hl2 + "s%" + hr2 + "s\n", h2, "|");
        System.out.printf("|                          [3] %"+ hl3 + "s%" + hr3 + "s\n", h3, "|");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (a | b | c)                         |");
        System.out.println("---------------------------------------------------------------------");
    }

    void listDeadAlly (IParty playerParty){
        String h1 = playerParty.getCharacters().get(0).getName();String h2 = playerParty.getCharacters().get(1).getName();String h3 = playerParty.getCharacters().get(2).getName();
        int hl1 = 7 + h1.length()+1;
        int hr1 = 22 - hl1 + 1;

        int hl2 = 7 + h2.length();
        int hr2 = 22 - hl2 + 1;

        int hl3 = 7 + h3.length();
        int hr3 = 22 - hl3 + 1;

        System.out.println("                       Choose your target hero                      ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             List Ally                             |");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("|                          [1] %"+ hl1 + "s%" + hr1 + "s\n", h1, "|");
        System.out.printf("|                          [2] %"+ hl2 + "s%" + hr2 + "s\n", h2, "|");
        System.out.printf("|                          [3] %"+ hl3 + "s%" + hr3 + "s\n", h3, "|");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (a | b | c)                         |");
        System.out.println("---------------------------------------------------------------------");
    }

    void listEnemy (IParty cpuParty){
        String h1 = cpuParty.getCharacters().get(0).getName();String h2 = cpuParty.getCharacters().get(1).getName();String h3 = cpuParty.getCharacters().get(2).getName();
        int hl1 = 7 + h1.length()+1;
        int hr1 = 22 - hl1 + 1;

        int hl2 = 7 + h2.length();
        int hr2 = 22 - hl2 + 1;

        int hl3 = 7 + h3.length();
        int hr3 = 22 - hl3 + 1;

        System.out.println("                       Choose your target hero                      ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             List Enemy                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("|                          [1] %"+ hl1 + "s%" + hr1 + "s\n", h1, "|");
        System.out.printf("|                          [2] %"+ hl2 + "s%" + hr2 + "s\n", h2, "|");
        System.out.printf("|                          [3] %"+ hl3 + "s%" + hr3 + "s\n", h3, "|");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (a | b | c)                         |");
        System.out.println("---------------------------------------------------------------------");

    }



    void hasSkill1 (Hero hero){
        String s1 = hero.getSkill1().getName();
        int sr1 = 40 - s1.length();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                               Skill                               |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        [a] Basic Attack                           |");
        System.out.println("|                        [b] Special Attack                          |");
        System.out.printf("|                        [c] %s%" + sr1 + "s\n", s1, "|");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                         Select (a | b | c)                        |");
        System.out.println("---------------------------------------------------------------------");
    }

    void hasSkill2 (Hero hero){

        String s1 = hero.getSkill1().getName();
        int sr1 = 40 - s1.length();

        String s2 = hero.getSkill2().getName();
        int sr2 = 40 - s2.length();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                               Skill                               |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        [a] Basic Attack                           |");
        System.out.println("|                        [b] Special Attack                          |");
        System.out.printf("|                        [c] %s%" + sr1 + "s\n",s1, "|");
        System.out.printf("|                        [c] %s%" + sr2 + "s\n", s2, "|");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                         Select (a | b | c)                        |");
        System.out.println("---------------------------------------------------------------------");
    }

    void heropedia() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           HERO ALMANAC                            |");
        System.out.println("|===================================================================|");
        System.out.println("|              MURBY             |               HELLDA             |");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");
        System.out.println("|                                |                                  |");


    }


    void playAgainOrNo (){

    }


    void thankYou (){

    }

    void listSkill (){

    }


}
