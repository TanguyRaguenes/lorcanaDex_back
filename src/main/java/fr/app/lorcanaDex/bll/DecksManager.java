package fr.app.lorcanaDex.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.app.lorcanaDex.bo.Deck;
import fr.app.lorcanaDex.dao.IDecksDao;

@Service
public class DecksManager implements IDecksManager {

    // ATTRIBUTS

    private IDecksDao decksDao;

    // CONSTRUCTEUR

    public DecksManager(IDecksDao decksDao) {
        this.decksDao = decksDao;
    }

    // METHODES

    @Override
    public void addDeckToBdd(Deck deck) {
        decksDao.addDeckToBdd(deck);
    }

    @Override
    public List<Deck> getDecksFromBdd(String username) {
        return decksDao.getDecksFromBdd(username);
    }

}
