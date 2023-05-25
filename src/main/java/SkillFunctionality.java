public class SkillFunctionality {

    public static int getAttackAfterEffect(Hero hero) {
        int attackDamage = hero.getAttack();
        if (hero.getEffect().hasAtkBuff()) attackDamage += (int) (hero.getAttack() * hero.getEffect().getAtkBuffModifier());
        if (hero.getEffect().hasAtkDebuff()) attackDamage -= (int) (hero.getAttack() * hero.getEffect().getAtkDebuffModifier());
        return attackDamage;
    }

    public static int getDefenceAfterEffect(Hero hero) {
        int defense = hero.getDefense();
        if (hero.getEffect().hasDefBuff()) defense += (int) (hero.getDefense() * hero.getEffect().getDefBuffModifier());
        if (hero.getEffect().hasDefDebuff()) defense -= (int) (hero.getDefense() * hero.getEffect().getDefDebuffModifier());
        return defense;
    }

    public static void modifiedBasicAtack(Hero hero, Hero target, double damageMultiplier) {
        int totalAtk = (int) (getAttackAfterEffect(hero) * damageMultiplier);
        totalAtk -= getDefenceAfterEffect(target);
        if (totalAtk <= 0) totalAtk = 1;
        target.setHP(target.getHP() - totalAtk);
        target.updateIsDefeated();
    }

    public static void trueDamage(Hero hero, Hero target, double multiplier) {
        int totalAtk = (int) (getAttackAfterEffect(hero) * multiplier);
        if (totalAtk <= 0) totalAtk = 1;
        target.setHP(target.getHP() - totalAtk);
        target.updateIsDefeated();
    }

    public static void healthDrainMaxHealth(Hero target, double multiplier) {
        int totalDamage = (int) (target.getMaxHp() * multiplier);
        target.setHP(target.getHP() - totalDamage);
        target.updateIsDefeated();
    }

    public static void stun(Hero target, int duration) {
        if (target.getEffect().isStunned() && target.getEffect().getStunDuration() > duration) return;
        target.getEffect().setStunDuration(duration);
    }

    public static void healAtkBase(Hero hero, Hero target, double multiplier) {
        int healAmount = (int) (getAttackAfterEffect(hero) * multiplier);
        target.setHP(target.getHP() + healAmount);
        if (target.getHP() > target.getMaxHp()) target.setHP(target.getMaxHp());
    }

    public static void healMaxHpBase(Hero target, double multiplier) {
        int healAmount = (int) (target.getMaxHp() * multiplier);
        target.setHP(target.getHP() + healAmount);
        if (target.getHP() > target.getMaxHp()) target.setHP(target.getMaxHp());
    }

    public static void manaDrainAtkBase(Hero hero, Hero target, double multiplier) {
        int drainAmount = (int) (getAttackAfterEffect(hero) * multiplier);
        target.setMana(target.getMana() - drainAmount);
    }

    public static void manaDrainMaxManaBase(Hero target, double multiplier) {
        int drainAmount = (int) (target.getMaxMana() * multiplier);
        target.setMana(target.getMana() - drainAmount);
    }

    public static void manaRegen(Hero hero, Hero target, double multiplier) {
        int regenAmount = (int) (getAttackAfterEffect(hero) * multiplier);
        target.setMana(target.getMana() + regenAmount);
    }

    public static void taunt(Hero hero, Hero target, int duration) {
        if (target.getEffect().isTaunted() && target.getEffect().getTauntDuration() > duration) return;
        target.getEffect().setTauntDuration(duration);
        target.getEffect().setTauntingHero(hero);
    }

    public static void purify(Hero target) {
        target.getEffect().nullifyAllDebuff();
    }

    public static void resurrect(Hero hero, Hero target) {
        target.makeAlive();
        target.setHP((int) (0.5 * target.getMaxHp()));
    }

    public static void atkBuff(Hero target, int duration, double buffMultiplier) {
        if (target.getEffect().hasAtkBuff() && target.getEffect().getAtkBuffModifier() > buffMultiplier) return;
        target.getEffect().setAtkBuffDuration(duration);
        target.getEffect().setAtkBuffModifier(buffMultiplier);
    }

    public static void defBuff(Hero target, int duration, double buffMultiplier) {
        if (target.getEffect().hasDefBuff() && target.getEffect().getDefBuffModifier() > buffMultiplier) return;
        target.getEffect().setDefBuffDuration(duration);
        target.getEffect().setDefBuffModifier(buffMultiplier);
    }

    public static void atkDebuff(Hero target, int duration, double debuffMultiplier) {
        if (target.getEffect().hasAtkDebuff() && target.getEffect().getAtkDebuffModifier() > debuffMultiplier) return;
        target.getEffect().setAtkDebuffDuration(duration);
        target.getEffect().setAtkDebuffModifier(debuffMultiplier);
    }

    public static void defDebuff(Hero target, int duration, double debuffMultiplier) {
        if (target.getEffect().hasDefDebuff() && target.getEffect().getDefDebuffModifier() > debuffMultiplier) return;
        target.getEffect().setDefDebuffDuration(duration);
        target.getEffect().setDefDebuffModifier(debuffMultiplier);
    }
}
