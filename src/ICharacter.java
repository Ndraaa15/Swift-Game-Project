public interface ICharacter {
    // dapat berakibat berkurangnya HP lawan
    // damage yang dihasilkan normalAttack tidak bergantung pada tipe karakter
    public void normalAttack(ICharacter opponent);

    // dapat berakibat berkurangnya HP lawan
    // damage yang dihasilkan specialAttack bergantung pada tipe karakter
    public void specialAttack(ICharacter opponent);

    // untuk mengetahui apakah player sudah dikalahkan (HP <= 0) atau masih bisa digunakan
    public boolean isDefeated();


    // methods di bawah ini terkait dengan atribut karakter:

    public void setName(String name);

    public void setCharacterType(characterType type);

    public void setHP(int hp);

    public void setAttack(int attack);

    public void setDefense(int defense);

    public String getName();

    public characterType getCharacterType();

    public int getHP();

    public int getAttack();

    public int getDefense();

    public enum characterType {
        FIRE, GRASS, WATER
    }

}
