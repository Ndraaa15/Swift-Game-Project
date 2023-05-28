import java.util.ArrayList;

class Effect {
    private int stunDuration;

    private int tauntDuration;
    private Hero tauntingHero;

    private int atkBuffDuration;
    private double atkBuffModifier;

    private int defBuffDuration;
    private double defBuffModifier;

    private int atkDebuffDuration;
    private double atkDebuffModifier;

    private int defDebuffDuration;
    private double defDebuffModifier;


    //STUN
    public boolean isStunned() {
        return stunDuration != 0;
    }

    public int getStunDuration() {
        return stunDuration;
    }

    public void setStunDuration(int stunDuration) {
        this.stunDuration = stunDuration;
    }

    public void decrementStunDuration() {
        if (stunDuration == 0) return;
        stunDuration--;
    }

    public void nullifyStun() {
        stunDuration = 0;
    }

    // TAUNT
    public boolean isTaunted() {
        return tauntDuration != 0;
    }

    public int getTauntDuration() {
        return tauntDuration;
    }

    public Hero getTauntingHero() {
        return tauntingHero;
    }

    public void setTauntDuration(int tauntDuration) {
        this.tauntDuration = tauntDuration;
        if (tauntDuration == 0) setTauntingHero(null);
    }

    public void setTauntingHero(Hero tauntingHero) {
        this.tauntingHero = tauntingHero;
    }

    public void decrementTauntDuration() {
        if (tauntDuration == 0) return;
        tauntDuration--;
        if (tauntDuration == 0) setTauntingHero(null);
    }

    public void nullifyTaunt() {
        tauntDuration = 0;
        tauntingHero = null;
    }

    // ATK BUFF
    public boolean hasAtkBuff() {
        return atkBuffDuration != 0;
    }

    public int getAtkBuffDuration() {
        return atkBuffDuration;
    }

    public double getAtkBuffModifier() {
        return atkBuffModifier;
    }

    public void setAtkBuffDuration(int atkBuffDuration) {
        this.atkBuffDuration = atkBuffDuration;
        if (atkBuffDuration < 0) atkBuffDuration = 0;
        if (atkBuffDuration == 0) atkBuffModifier = 0;
    }

    public void setAtkBuffModifier(double atkBuffModifier) {
        this.atkBuffModifier = atkBuffModifier;
    }

    public void decrementAtkBuffDuration() {
        if (atkBuffDuration == 0) return;
        atkBuffDuration--;
        if (atkBuffDuration == 0) atkBuffModifier = 0;
    }

    public void nullifyAtkBuff() {
        setAtkBuffDuration(0);
        setAtkBuffModifier(0);
    }

    // DEF BUFF
    public boolean hasDefBuff() {
        return defBuffDuration != 0;
    }

    public int getDefBuffDuration() {
        return defBuffDuration;
    }

    public double getDefBuffModifier() {
        return defBuffModifier;
    }

    public void setDefBuffDuration(int defBuffDuration) {
        this.defBuffDuration = defBuffDuration;
        if (defBuffDuration < 0) defBuffDuration = 0;
        if (defBuffDuration == 0) defBuffModifier = 0;
    }

    public void setDefBuffModifier(double defBuffModifier) {
        this.defBuffModifier = defBuffModifier;
    }

    public void decrementDefBuffDuration() {
        if (defBuffDuration == 0) return;
        defBuffDuration--;
        if (defBuffDuration == 0) defBuffModifier = 0;
    }

    public void nullifyDefBuff() {
        setDefBuffDuration(0);
        setDefBuffModifier(0);
    }

    // ATK DEBUFF
    public boolean hasAtkDebuff() {
        return atkDebuffDuration != 0;
    }

    public int getAtkDebuffDuration() {
        return atkDebuffDuration;
    }

    public double getAtkDebuffModifier() {
        return atkDebuffModifier;
    }

    public void setAtkDebuffDuration(int atkDebuffDuration) {
        this.atkDebuffDuration = atkDebuffDuration;
        if (atkDebuffDuration < 0) atkDebuffDuration = 0;
        if (atkDebuffDuration == 0) atkDebuffModifier = 0;
    }

    public void setAtkDebuffModifier(double atkDebuffModifier) {
        this.atkDebuffModifier = atkDebuffModifier;
    }

    public void decrementAtkDebuffDuration() {
        if (atkDebuffDuration == 0) return;
        atkDebuffDuration--;
        if (atkDebuffDuration == 0) atkDebuffModifier = 0;
    }

    public void nullifyAtkDebuff() {
        setAtkDebuffDuration(0);
        setAtkDebuffModifier(0);
    }

    // DEF DEBUFF
    public boolean hasDefDebuff() {
        return defDebuffDuration != 0;
    }

    public int getDefDebuffDuration() {
        return defDebuffDuration;
    }

    public double getDefDebuffModifier() {
        return defDebuffModifier;
    }

    public void setDefDebuffDuration(int defDebuffDuration) {
        this.defDebuffDuration = defDebuffDuration;
        if (defDebuffDuration < 0) defDebuffDuration = 0;
        if (defDebuffDuration == 0) defDebuffModifier = 0;
    }

    public void setDefDebuffModifier(double defDebuffModifier) {
        this.defDebuffModifier = defDebuffModifier;
    }

    public void decrementDefDebuffDuration() {
        if (defDebuffDuration == 0) return;
        defDebuffDuration--;
        if (defDebuffDuration == 0) defDebuffModifier = 0;
    }

    public void nullifyDefDebuff() {
        setDefDebuffDuration(0);
        setDefDebuffModifier(0);
    }

    // ALL
    public void nullifyAll() {
        nullifyStun();
        nullifyTaunt();
        nullifyAtkBuff();
        nullifyDefBuff();
        nullifyAtkDebuff();
        nullifyDefDebuff();
    }

    public void nullifyAllDebuff() {
        nullifyStun();
        nullifyTaunt();
        nullifyAtkDebuff();
        nullifyDefDebuff();
    }

    public void nullifyAllBuff() {
        nullifyAtkBuff();
        nullifyDefBuff();
    }

    public void decrementAll() {
        decrementStunDuration();
        decrementTauntDuration();
        decrementAtkBuffDuration();
        decrementDefBuffDuration();
        decrementAtkDebuffDuration();
        decrementDefDebuffDuration();
    }

    public boolean hasAnyEffect() {
        ArrayList<Boolean> hasEffects = new ArrayList<>();
        hasEffects.add(isStunned());
        hasEffects.add(isTaunted());
        hasEffects.add(hasAtkBuff());
        hasEffects.add(hasDefBuff());
        hasEffects.add(hasAtkDebuff());
        hasEffects.add(hasDefDebuff());

        boolean hasAnyEffect = false;
        for (boolean hasEffect : hasEffects) {
            hasAnyEffect = hasAnyEffect || hasEffect;
        }
        return hasAnyEffect;
    }

    public String getEffectDisplay() {
        if (!hasAnyEffect()) return null;
        String display = "";
        if (isStunned()) display += "S ";
        if (isTaunted()) display += "T ";
        if (hasAtkBuff()) display += "AB ";
        if (hasDefBuff()) display += "DB ";
        if (hasAtkDebuff()) display += "AD ";
        if (hasDefDebuff()) display += "DD ";

        if (display.charAt(display.length() - 1) == ' ') {
            display = display.substring(0, display.length() - 1);
        }
        return display;
    }
}
