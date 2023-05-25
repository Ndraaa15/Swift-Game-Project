import java.util.ArrayList;

public class Party implements IParty{
    String partyName;
    ArrayList<Hero> characters = new ArrayList<>();
    boolean isTurn;

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    @Override
    public String getPartyName() {
        return partyName;
    }

    @Override
    public ArrayList<Hero> getCharacters() {
        return characters;
    }

    public Party(String partyName, Hero ICharacter1, Hero ICharacter2, Hero ICharacter3){
        this.partyName = partyName;
        this.characters.add(ICharacter1);
        this.characters.add(ICharacter2);
        this.characters.add(ICharacter3);
    }
    @Override
    public Hero nextPlayer() {
        return null;
    }

    @Override
    public boolean hasNextPlayer() {
        return characters.isEmpty();
    }

    @Override
    public boolean isDefeated() {
        return characters.get(0).isDefeated() && characters.get(1).isDefeated() && characters.get(2).isDefeated();
    }
}
