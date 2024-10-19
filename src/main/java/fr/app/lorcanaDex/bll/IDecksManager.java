package fr.app.lorcanaDex.bll;

import fr.app.lorcanaDex.bo.Deck;
import java.util.List;

public interface IDecksManager {

    public void addDeckToBdd(Deck deck);

    public List<Deck> getDecksFromBdd(String username);

}
