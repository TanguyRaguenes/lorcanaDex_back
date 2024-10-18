package fr.app.lorcanaDex.bll;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.app.lorcanaDex.bo.Deck;
import fr.app.lorcanaDex.dao.IDecksDao;

@Service
public class DeckManager implements IDecksManager {

    private IDecksDao decksDao;

    public DeckManager(IDecksDao decksDao) {
        this.decksDao = decksDao;
    }

    @Override
    public void addDeckToBdd(Deck deck) {
        decksDao.addDeckToBdd(deck);
    }

}
