

public class Display {
    void gameField (IParty playerParty, IParty cpuParty){
        String team = playerParty.getPartyName() + "'s Team";
        int x = 5 + team.length();
        int y = 23 - x;

        //Player
        Hero h1 = playerParty.getCharacters().get(0);Hero h2 = playerParty.getCharacters().get(1);Hero h3 = playerParty.getCharacters().get(2);
        //Hero 1
        String hPla1 = h1.getName() + " | " + h1.getMana();
        int hPla1l = hPla1.length() + 4; int hPla1r = 23 - hPla1l;

        String atrH1 = h1.getHeroElement().toString() + " | " +h1.getHeroRole().toString();
        int atrH1l = atrH1.length() + 4; int atrH1r = 23 - atrH1l;

        String hpH1 = String.valueOf(h1.getHP());
        int hpH1l = 2 + hpH1.length(); int hpH1r = 7 - hpH1l;

        String atkH1 = String.valueOf(h1.getAttack());
        int atkH1l = 2 + atkH1.length(); int atkH1r = 8 - atkH1l;

        String defH1 = String.valueOf(h1.getDefense());
        int defH1l = 2 + defH1.length(); int defH1r = 8 - defH1l;


        //Hero 2
        String hPla2 = h2.getName() + " | " + h2.getMana();
        int hPla2l = hPla1.length() + 4 ; int hPla2r = 23 - hPla1l;

        String atrH2 = h2.getHeroElement().toString() + " | " +h2.getHeroRole().toString();
        int atrH2l = atrH2.length() + 4; int atrH2r = 23 - atrH2l;

        String hpH2 = String.valueOf(h2.getHP());
        int hpH2l = 2 + hpH2.length(); int hpH2r = 7 - hpH2l;

        String atkH2 = String.valueOf(h2.getAttack());
        int atkH2l = 2 + atkH1.length(); int atkH2r = 8 - atkH2l;

        String defH2 = String.valueOf(h2.getDefense());
        int defH2l = 2 + defH2.length(); int defH2r = 8 - defH2l;


        //Hero 3
        String hPla3 = h3.getName() + " | " + h3.getMana();
        int hPla3l = hPla3.length() + 4; int hPla3r = 23 - hPla3l;

        String atrH3 = h3.getHeroElement().toString() + " | " +h3.getHeroRole().toString();
        int atrH3l = atrH3.length() + 4; int atrH3r = 23 - atrH3l;

        String hpH3 = String.valueOf(h3.getHP());
        int hpH3l = 2 + hpH3.length(); int hpH3r = 7 - hpH3l;

        String atkH3 = String.valueOf(h3.getAttack());
        int atkH3l = 2 + atkH3.length(); int atkH3r = 8 - atkH3l;

        String defH3 = String.valueOf(h3.getDefense());
        int defH3l = 2 + defH3.length(); int defH3r = 8 - defH3l;


        //Enemy
        Hero e1 = cpuParty.getCharacters().get(0);Hero e2 = cpuParty.getCharacters().get(1);Hero e3 = cpuParty.getCharacters().get(2);
        //Enemy 1
        String hE1 = e1.getName() + " | " + e1.getMana();
        int hE1l = hE1.length() + 4; int hE1r = 23 - hE1l;

        String atrE1 = e1.getHeroElement().toString() + " | " +e1.getHeroRole().toString();
        int atrE1l = atrE1.length() + 4; int atrE1r = 23 - atrE1l;

        String hpE1 = String.valueOf(e1.getHP());
        int hpE1l = 2 + hpE1.length(); int hpE1r = 7 - hpH1l;

        String atkE1 = String.valueOf(e1.getAttack());
        int atkE1l = 2 + atkE1.length(); int atkE1r = 8 - atkH1l;

        String defE1 = String.valueOf(e1.getDefense());
        int defE1l = 2 + defE1.length(); int defE1r = 8 - defH1l;


        //Enemy 2
        String hE2 = e2.getName() +  " | " + e2.getMana();
        int hE2l = hE2.length() + 4; int hE2r = 23 - hE2l;

        String atrE2 = e2.getHeroElement().toString() + " | " +e2.getHeroRole().toString();
        int atrE2l = atrE2.length() + 4; int atrE2r = 23 - atrE2l;

        String hpE2 = String.valueOf(e2.getHP());
        int hpE2l = 2 + hpE2.length(); int hpE2r = 7 - hpE2l;

        String atkE2 = String.valueOf(e2.getAttack());
        int atkE2l = 2 + atkE2.length(); int atkE2r = 8 - atkE2l;

        String defE2 = String.valueOf(e2.getDefense());
        int defE2l = 2 + defE2.length(); int defE2r = 8 - defE2l;



        //Enemy 3
        String hE3 = e3.getName() + " | " + e3.getMana();
        int hE3l = hE3.length() + 4; int hE3r = 23 - hE3l;

        String atrE3 = e3.getHeroElement().toString() + " | " +e3.getHeroRole().toString();
        int atrE3l = atrE3.length() + 4; int atrE3r = 23 - atrE3l;

        String hpE3 = String.valueOf(e3.getHP());
        int hpE3l = 2 + hpE3.length(); int hpE3r = 7 - hpE3l;

        String atkE3 = String.valueOf(e3.getAttack());
        int atkE3l = 2 + atkE2.length(); int atkE3r = 8 - atkE3l;

        String defE3 = String.valueOf(e3.getDefense());
        int defE3l = 2 + defE3.length(); int defE3r = 8 - defE3l;



        System.out.println();
        System.out.println("|===================================================================|");
        System.out.printf("|%" + x + "s%" + y + "s    BRAWL HEROES     |         COM     [ X ]|\n", team, "|");
        System.out.println("|===================================================================|");
        System.out.println("|          1           |                     |          1           |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.printf("|%" + hPla1l + "s%" + hPla1r + "s                     |%" + hE1l + "s%" + hE1r + "s\n", hPla1, "|", hE1, "|"); // Name
        System.out.printf("|%" + atrH1l + "s%" + atrH1r + "s                     |%" + atrE1l + "s%" + atrE1r + "s\n", atrH1, "|", atrE1, "|"); //element | role
        System.out.println("|----------------------|                     |----------------------|");
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("HP   : %d/%d", h1.getHP(), h1.getMaxHp()), String.format("HP   : %d/%d", e1.getHP(), e1.getMaxHp()));
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("MANA : %d/%d", h1.getMana(), h1.getMaxMana()), String.format("MANA : %d/%d", e1.getMana(), e1.getMaxMana()));
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("ATK  : %d", h1.getAttack()), String.format("ATK  : %d", e1.getAttack()));
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("DEF  : %d", h1.getDefense()), String.format("DEF  : %d", e1.getDefense()));
        System.out.printf("| %-20s |                     | %-20s |\n", h1.getCondition(), e1.getCondition());
        System.out.println("|======================|                     |======================|");
        System.out.println("|          2           |                     |          2           |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.printf("|%" + hPla2l + "s%" + hPla2r + "s  ██      ██ ██████  |%" + hE2l + "s%" + hE2r +  "s\n", hPla2, "|", hE2, "|");
        System.out.printf("|%" + atrH2l + "s%" + atrH2r + "s   ██    ██ ██       |%" + atrE2l + "s%" + atrE2r + "s\n", atrH2, "|", atrE2, "|");
        System.out.println("|----------------------|    ██  ██   █████   |----------------------|");
        System.out.printf("| %-20s |     ████        ██  | %-20s |\n", String.format("HP   : %d/%d", h2.getHP(), h2.getMaxHp()), String.format("HP   : %d/%d", e2.getHP(), e2.getMaxHp()));
        System.out.printf("| %-20s |      ██    ██████   | %-20s |\n", String.format("MANA : %d/%d", h2.getMana(), h2.getMaxMana()), String.format("MANA : %d/%d", e1.getMana(), e2.getMaxMana()));
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("ATK  : %d", h2.getAttack()), String.format("ATK  : %d", e2.getAttack()));
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("DEF  : %d", h2.getDefense()), String.format("DEF  : %d", e2.getDefense()));
        System.out.printf("| %-20s |                     | %-20s |\n", h2.getCondition(), e2.getCondition());
        System.out.println("|======================|                     |======================|");
        System.out.println("|          3           |                     |          3           |");
        System.out.println("|----------------------|                     |----------------------|");
        System.out.printf("|%" + hPla3l + "s%" + hPla3r + "s                     |%" + hE3l + "s%" + hE3r + "s\n", hPla3, "|", hE3, "|"); // Name
        System.out.printf("|%" + atrH3l + "s%" + atrH3r + "s                     |%" + atrE3l + "s%" + atrE3r + "s\n", atrH3, "|", atrE3, "|"); //element | role
        System.out.println("|----------------------|                     |----------------------|");
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("HP   : %d/%d", h3.getHP(), h3.getMaxHp()), String.format("HP   : %d/%d", e3.getHP(), e3.getMaxHp()));
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("MANA : %d/%d", h3.getMana(), h3.getMaxMana()), String.format("MANA : %d/%d", e3.getMana(), e3.getMaxMana()));
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("ATK  : %d", h3.getAttack()), String.format("ATK  : %d", e3.getAttack()));
        System.out.printf("| %-20s |                     | %-20s |\n", String.format("DEF  : %d", h3.getDefense()), String.format("DEF  : %d", e3.getDefense()));
        System.out.printf("| %-20s |                     | %-20s |\n", h3.getCondition(), e3.getCondition());
        System.out.println("|===================================================================|");
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
        System.out.println("|                           [c] HeroesPedia                         |");
        System.out.println("|                           [d] Exit Game                           |");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select ( a | b | c )                       |");
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
        System.out.println("|                          Select ( a | b )                         |");
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
        System.out.println("|                          Select ( a | b )                         |");
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
        System.out.println("|                       Select ( a | b | c )                        |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");
    }

    void listHero (){
        System.out.println();
        System.out.println("                        Select Your 3 Heroes                        ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                            LIST HERO                              |");
        System.out.println("|===================================================================|");
        System.out.println("|         Fire         |        Grass        |        Water         |");
        System.out.println("|===================================================================|");
        System.out.println("| [1] Murby  | Fighter | [5] Grove | Tank    | [9]  Theseus| Tank   |");
        System.out.println("| [2] Helda  | Tank    | [6] Elisa | Mage    | [10] Atla   | Archer |");
        System.out.println("| [3] Veld   | Mage    | [7] Lily  | Archer  | [11] Marie  | Support|");
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
        System.out.print("| Enter your name party (max : 10 letters) : ");
    }

    void brawlHeroes (){
        System.out.println("░█▀▀█ ░█▀▀█ ─█▀▀█ ░█──░█ ░█───  ░█─░█ ░█▀▀▀ ░█▀▀█ ░█▀▀▀█ ░█▀▀▀ ░█▀▀▀█ ");
        System.out.println("░█▀▀▄ ░█▄▄▀ ░█▄▄█ ░█░█░█ ░█───  ░█▀▀█ ░█▀▀▀ ░█▄▄▀ ░█──░█ ░█▀▀▀ ─▀▀▀▄▄ ");
        System.out.println("░█▄▄█ ░█─░█ ░█─░█ ░█▄▀▄█ ░█▄▄█  ░█─░█ ░█▄▄▄ ░█─░█ ░█▄▄▄█ ░█▄▄▄ ░█▄▄▄█ ");
        System.out.println("|                              2023                                 |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|               Unleash Your Team's Might in Brawl Heroes           |");
        System.out.println("|                    Triumph in Turn-based Battles!                 |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|              INDRA | JAVIER | RAFIQI | LUCAS | GRATIA             |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println();
    }

    void createHero(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                           Create a Hero                           |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|         Unleash your imagination and forge an extraordinary       |");
        System.out.println("|                         hero from scratch!                        |");
        System.out.println("---------------------------------------------------------------------");
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

    void listAlly (IParty playerParty, String heroUseSkill){
        System.out.println("                       Choose your target hero                      ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             List Ally                             |");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < playerParty.getCharacters().size(); i++) {
            if (!playerParty.getCharacters().get(i).isDefeated() && !playerParty.getCharacters().get(i).getName().equals(heroUseSkill)){
                String h = playerParty.getCharacters().get(i).getName();
                int s = 36 - h.length();
                System.out.printf("|                            [" + (i+1) + "] %s%" + s + "s\n", h, "|");
            }
        }
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (1 | 2 | 3)                         |");
        System.out.println("---------------------------------------------------------------------");
    }

    void listDeadAlly (IParty playerParty){
        System.out.println("                       Choose your target hero                      ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             List Ally                             |");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < playerParty.getCharacters().size(); i++) {
            if (playerParty.getCharacters().get(i).isDefeated()){
                String h = playerParty.getCharacters().get(i).getName();
                int s = 36 - h.length();
                System.out.printf("|                            [" + (i+1) + "] %s%" + s + "s\n", h, "|");
            }
        }
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (1 | 2 | 3)                         |");
        System.out.println("---------------------------------------------------------------------");
    }

    void listEnemy (IParty cpuParty){
        System.out.println("                       Choose your target hero                      ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             List Enemy                            |");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < cpuParty.getCharacters().size(); i++) {
            if (!cpuParty.getCharacters().get(i).isDefeated()){
                String h = cpuParty.getCharacters().get(i).getName();
                int s = 36 - h.length();
                System.out.printf("|                            [" + (i+1) + "] %s%" + s + "s\n", h, "|");
            }
        }
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select (1 | 2 | 3)                         |");
        System.out.println("---------------------------------------------------------------------");

    }



    void hasSkill1 (Hero hero){
        String s1 = hero.getSkill1().getName();
        int sr1 = 40 - s1.length();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                               Skill                               |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        [1] Basic Attack                           |");
        System.out.println("|                        [2] Special Attack                         |");
        System.out.printf("|                        [3] %s%" + sr1 + "s\n", s1, "|");
        System.out.println("|                                                                   |");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Select ( 1 | 2 | 3 )                       |");
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
        System.out.printf("|                         [c] %s%" + sr1 + "s\n",s1, "|");
        System.out.printf("|                         [c] %s%" + sr2 + "s\n", s2, "|");
        System.out.println("|                            Swift Games                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                      Select (a | b | c | d)                       |");
        System.out.println("---------------------------------------------------------------------");
    }

    void heroespedia() {
        System.out.println("|===================================================================|");
        System.out.println("|                           HERO ALMANAC                            |");
        System.out.println("|===================================================================|");
        System.out.println("|             MURBY               |               HELLDA            |");
        System.out.println("|         FIRE | FIGHTER          |            FIRE | TANK          |");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("| HP : 400 | ATK : 55 | DEF : 16  | HP : 490 | ATK : 35 | DEF : 24  |");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("| FIREBALL BARAGE:                | ASHEN GROWL:                    |");
        System.out.println("| Deal 3x atk to an enemy         | Deal 0.5 atk and taunts         |");
        System.out.println("|                                 | an enemy for 3 turns            |");
        System.out.println("|                                 |                                 |");
        System.out.println("|                                 | FLAME ARMOR:                    |");
        System.out.println("|                                 | Increase all ally defense       |");
        System.out.println("|                                 | by 15% for 5 turns              |");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("| LORE:                           | LORE:                           |");
        System.out.println("| Fell Orc yang bangkit dari      | Prajurit yang tumbuh besar di   |");
        System.out.println("| neraka dan mewarisi Cullenors   | desa suku minotaurus, Helzores. |");
        System.out.println("| axe dari api kegelapan.         | Api Ofyhz bernaung memberikan   |");
        System.out.println("|                                 | keabadian pada dirinya          |");
        System.out.println("|                                 |                                 |");
        System.out.println("|===================================================================|");
        System.out.println("|                              [b] Back                             |");
        System.out.println("|===================================================================|");
        System.out.print("Your Choice : ");
    }

    void skillList() {
        System.out.println("|===================================================================|");
        System.out.println("|                             PICK SKILL                            |");
        System.out.println("|===================================================================|");
        System.out.println("| [01] FIREBALL BARAGE : 50       | [13] FROST ARMOR : 20           |");
        System.out.println("|      Deal 3x atk to an enemy.   |      Increase an ally def by    |");
        System.out.println("|                                 |      0.2 5T.                    |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [02] ASHEN GROWN : 55           | [14] WATER CANNON : 30          |");
        System.out.println("|      Taunts 3T and deal 0.5x    |      Deal 25% max hp damage     |");
        System.out.println("|      atk to an enemy.           |      to an enemy.               |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [03] FLAME ARMOR : 60           | [15] HEALING WATER : 30         |");
        System.out.println("|      Increase all ally def by   |      Heal 20% max hp of         |");
        System.out.println("|      15% for 5T.                |      an ally.                   |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [04] ARMOR BURN : 65            | [16] BLIZZARD : 80              |");
        System.out.println("|      All enemy def decreased    |      Decrease all enemy atk     |");
        System.out.println("|      60% 3T and deal 0.2x atk.  |      by 10% for 10 turns.       |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [05] FIRE STAFF : 30            | [17] WATER SLASH : 50           |");
        System.out.println("|      Increase hero atk          |      Deal 3x true damage to     |");
        System.out.println("|      by 2x 3T.                  |      an enemy.                  |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [06] INFERNAL SHOT : 30         | [18] -                          |");
        System.out.println("|      Stun 1T and deal 1.5 atk   |                                 |");
        System.out.println("|      to an enemy.               |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [07] GRASSROOT GUARDIAN : 60    | [19] -                          |");
        System.out.println("|      10% heal, 20% def buff 2T  |                                 |");
        System.out.println("|      to all ally.               |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [08] DRAINING VINE : 85         | [20] -                          |");
        System.out.println("|      Drain 50% max mana and hp  |                                 |");
        System.out.println("|      to an enemy.               |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [09] THORN ARROW : 20           | [21] -                          |");
        System.out.println("|      1.5x true damage to an     |                                 |");
        System.out.println("|      enemy.                     |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [10] LIFE REBLOSSOM : 85        | [22] -                          |");
        System.out.println("|      Resurrect an ally.         |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [11] NATURE CLEANSING : 20      | [23] -                          |");
        System.out.println("|      Purify an ally debuffs.    |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("| [12] NEEDLE RAIN : 25           | [24] -                          |");
        System.out.println("|      Deals 1x true damage to    |                                 |");
        System.out.println("|      all enemy.                 |                                 |");
        System.out.println("|                                 |                                 |");
        System.out.println("|===================================================================|");
    }


    void playAgainOrNo (){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                    Are you want to play again ?                   |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                             [y] Yes                               |");
        System.out.println("|                             [n] No                                |");
        System.out.println("|                                                                   |");
        System.out.println("|                           Swift Games                             |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                         Select ( y | n )                          |");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Your Choice : ");

    }

    void thankYou (){
        System.out.println("      ▀▀█▀▀ ▒█░▒█ ░█▀▀█ ▒█▄░▒█ ▒█░▄▀ 　 ▒█░░▒█ ▒█▀▀▀█ ▒█░▒█          ");
        System.out.println("      ░▒█░░ ▒█▀▀█ ▒█▄▄█ ▒█▒█▒█ ▒█▀▄░ 　 ▒█▄▄▄█ ▒█░░▒█ ▒█░▒█          ");
        System.out.println("      ░▒█░░ ▒█░▒█ ▒█░▒█ ▒█░░▀█ ▒█░▒█ 　 ░░▒█░░ ▒█▄▄▄█ ░▀▄▄▀          ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                    For Playing Brawl Heroes                       |");
        System.out.println("|                           Swift Games                             |");
        System.out.println("|                              2023                                 |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|            INDRA | JAVIER | RAFIQI | LUCAS | GRATIA               |");
        System.out.println("---------------------------------------------------------------------");
    }

    void saveGame (){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                     Save Game Succesfully                         |");
        System.out.println("---------------------------------------------------------------------");
    }
}
