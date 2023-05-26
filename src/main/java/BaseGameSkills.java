import java.util.ArrayList;

class BaseGameSkills {

    private static ArrayList<Skill> baseGameSkills = new ArrayList<>();
    static {
        // Add skills to the baseGameSkills ArrayList
        baseGameSkills.add(new FireballBarage());     // MURBY
        baseGameSkills.add(new AshenGrowl());         // HELLDA
        baseGameSkills.add(new FlameArmor());         // HELLDA
        baseGameSkills.add(new ArmorBurn());          // VELDORA
        baseGameSkills.add(new FireStaff());          // VELDORA
        baseGameSkills.add(new InfernalShot());       // DEUS
        baseGameSkills.add(new GrassrootGuardian());  // GROVE
        baseGameSkills.add(new DrainingVine());       // ELLISA
        baseGameSkills.add(new ThornArrow());         // LILY
        baseGameSkills.add(new LifeReblossom());      // FARANIST
        baseGameSkills.add(new NatureCleansing());    // FARANIST
        baseGameSkills.add(new NeedleRain());         // THESEUS
        baseGameSkills.add(new FrostArmor());         // THESEUS
        baseGameSkills.add(new WaterCannon());        // ATLANNA
        baseGameSkills.add(new HealingWater());       // MARIELLE
        baseGameSkills.add(new Blizzard());           // MARIELLE
        baseGameSkills.add(new WaterSlash());         // DILLON
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
        if (index > baseGameSkills.size() || index < 0) {
            System.out.println("Out of bounds");
            return null;
        }
        return baseGameSkills.get(index);
    }
}

