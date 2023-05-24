class Effect {
    private int stunDuration;

    private int tauntDuration;
    private Hero tauntingHero;

    private int atkBuffDuration;
    private int atkBuffModifier;

    private int defBuffDuration;
    private int defBuffModifier;


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

    public int getAtkBuffModifier() {
        return atkBuffModifier;
    }

    public void setAtkBuffDuration(int atkBuffDuration) {
        this.atkBuffDuration = atkBuffDuration;
        if (atkBuffDuration < 0) atkBuffDuration = 0;
        if (atkBuffDuration == 0) atkBuffModifier = 0;
    }

    public void setAtkBuffModifier(int atkBuffModifier) {
        this.atkBuffModifier = atkBuffModifier;
    }

    public void decrementAtkBuffDuration() {
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

    public int getDefBuffModifier() {
        return defBuffModifier;
    }

    public void setDefBuffDuration(int defBuffDuration) {
        this.defBuffDuration = defBuffDuration;
        if (defBuffDuration < 0) defBuffDuration = 0;
        if (defBuffDuration == 0) defBuffModifier = 0;
    }

    public void setDefBuffModifier(int atkBuffModifier) {
        this.defBuffModifier = defBuffModifier;
    }

    public void decrementDefBuffDuration() {
        defBuffDuration--;
        if (defBuffDuration == 0) defBuffModifier = 0;
    }

    public void nullifyDefBuff() {
        setDefBuffDuration(0);
        setDefBuffModifier(0);
    }

    // ALL
    public void nullifyAll() {
        nullifyStun();
        nullifyTaunt();
        nullifyAtkBuff();
        nullifyDefBuff();
    }

    public void decrementAll() {
        decrementStunDuration();
        decrementTauntDuration();
        decrementAtkBuffDuration();
        decrementDefBuffDuration();
    }
}
