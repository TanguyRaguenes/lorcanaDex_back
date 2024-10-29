package fr.app.lorcanaDex.dao;

import java.util.Map;

public interface IDeckDao {

    public void addCardsToDeck(Integer deckId, Map<Integer, Integer> cardsAndQuantity);

}
