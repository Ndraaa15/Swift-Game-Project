

public interface IGameEngine {

    // note: pastikan pada implementasi dapat dibedakan antara player party dan CPU party
    public IParty createPlayerParty(String partyName, Hero ICharacter1, Hero ICharacter2, Hero ICharacter3);
    public IParty createCPUParty(String partyName, Hero ICharacter1, Hero ICharacter2, Hero ICharacter3);

    // menyimpan game dengan cara melakukan serialisasi state semua objek ke JSON yang disimpan dalam sebuah file
    public void saveGame();

    // melanjutkan game dengan cara melakukan deserialisasi state semua objek dari file JSON
    public void loadGame();

    // mengetahui party mana yang memiliki giliran untuk menyerang
    public IParty nextTurn();

    // mengetahui apakah sudah ada party yang menang sehingga game dapat diakhiri
    public IParty winner();

}
