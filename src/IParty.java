public interface IParty {
    public ICharacter nextPlayer();

    public boolean hasNextPlayer();

    // untuk mengetahui apakah semua character pada party sudah dikalahkan (HP <= 0)
    public boolean isDefeated();
}
