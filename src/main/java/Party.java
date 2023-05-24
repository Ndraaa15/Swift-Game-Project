import java.util.ArrayList;

public class Party implements IParty{
    String partyName;
    ArrayList<ICharacter> characters = new ArrayList<>();


    public Party(String partyName, ICharacter ICharacter1, ICharacter ICharacter2, ICharacter ICharacter3){
        this.partyName = partyName;
        this.characters.add(ICharacter1);
        this.characters.add(ICharacter2);
        this.characters.add(ICharacter3);
    }
    @Override
    public ICharacter nextPlayer() {
        return null;
    }

    @Override
    public boolean hasNextPlayer() {
        return characters.isEmpty();
    }

    @Override
    public boolean isDefeated() {
        return !characters.get(0).isDefeated() && !characters.get(1).isDefeated() && !characters.get(2).isDefeated();
    }
}
