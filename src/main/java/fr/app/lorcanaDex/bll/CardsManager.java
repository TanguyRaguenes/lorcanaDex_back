package fr.app.lorcanaDex.bll;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.app.lorcanaDex.bo.Card;
import fr.app.lorcanaDex.bo.CardApiLorcast;
import fr.app.lorcanaDex.bo.SetApiLorcast;
import fr.app.lorcanaDex.dao.ICardsDao;

@Service
public class CardsManager implements ICardsManager {

    private ICardsDao cardsDao;

    public CardsManager(ICardsDao cardsDao) {
        this.cardsDao = cardsDao;
    }

    @Override
    public void bulk(List<SetApiLorcast> sets, List<CardApiLorcast> cards) {
        cardsDao.bulk(sets, cards);
    }

    @Override
    public void bulkData(List<Card> cards) {
        cardsDao.bulkData(cards);
    }

    @Override
    public List<CardApiLorcast> get() {
        return cardsDao.get();
    }

    @Override
    public List<Card> getCards() {
        return cardsDao.getCards();
    }

}
