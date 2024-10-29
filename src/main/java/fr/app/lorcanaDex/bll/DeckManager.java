package fr.app.lorcanaDex.bll;

import java.util.Map;

import org.springframework.stereotype.Service;

import fr.app.lorcanaDex.dao.IDeckDao;

@Service
public class DeckManager implements IDeckManager {

    private IDeckDao deckDao;

    public DeckManager(IDeckDao deckDao) {
        this.deckDao = deckDao;
    }

    @Override
    public void addCardsToDeck(Integer deckId, Map<Integer, Integer> cardsAndQuantity) {
        deckDao.addCardsToDeck(deckId,cardsAndQuantity);
    }

}
