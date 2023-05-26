import java.util.ArrayList;

class BaseGameSkills {

    private static ArrayList<Skill> baseGameSkills = new ArrayList<>();
    static {
        // MURBY
        Skill skill0 = new FireballBarage();

        // HELLDA
        Skill skill1 = new AshenGrowl();
        Skill skill2 = new FlameArmor();

        // VELDORA
        Skill skill3 = new ArmorBurn();
        Skill skill4 = new FireStaff();

        //DEUS
        Skill skill5 = new InfernalShot();

        // Grove
        Skill skill6 = new GrassrootGuardian();

        // ELLISA
        Skill skill7 = new DrainingVine();

        // LILY
        Skill skill8 = new ThornArrow();

        // FARANIST
        Skill skill9 = new LifeReblossom();
        Skill skill10 = new NatureCleansing();


        // THESEUS
        Skill skill11 = new NeedleRain();
        Skill skill12 = new FrostArmor();

        // ATLANNA
        Skill skill13 = new WaterCannon();

        // MARIELLE
        Skill skill14 = new HealingWater();
        Skill skill15 = new Blizzard();

        //DILLON
        Skill skill16 = new WaterSlash();


        // ADD SKILL TO ARRAYLIST
        baseGameSkills.add(skill0);
        baseGameSkills.add(skill1);
        baseGameSkills.add(skill2);
        baseGameSkills.add(skill3);
        baseGameSkills.add(skill4);
        baseGameSkills.add(skill5);
        baseGameSkills.add(skill6);
        baseGameSkills.add(skill7);
        baseGameSkills.add(skill8);
        baseGameSkills.add(skill9);
        baseGameSkills.add(skill10);
        baseGameSkills.add(skill11);
        baseGameSkills.add(skill12);
        baseGameSkills.add(skill13);
        baseGameSkills.add(skill14);
        baseGameSkills.add(skill15);
        baseGameSkills.add(skill16);
    }

    public static ArrayList<Skill> getBaseGameSkills() {
        return baseGameSkills;
    }

    public static Skill getSkill(String name) {
        for (Skill skill : baseGameSkills) {
            if (skill.getName().equals(name)) return skill;
        }
        return null;
    }

    public static Skill getSkill(int index) {
        if (index > baseGameSkills.size() || index < 0) return null;
        return baseGameSkills.get(index);
    }
}


