package fr.app.lorcanaDex.bll;

import java.util.Map;

public interface IDeckManager {
    public void addCardsToDeck(Integer deckId, Map<Integer, Integer> cardsAndQuantity);
}
