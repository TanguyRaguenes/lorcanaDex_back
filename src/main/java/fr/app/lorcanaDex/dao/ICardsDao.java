package fr.app.lorcanaDex.dao;

import java.util.List;

import fr.app.lorcanaDex.bo.Card;
import fr.app.lorcanaDex.bo.CardApiLorcast;
import fr.app.lorcanaDex.bo.SetApiLorcast;

public interface ICardsDao {

    public abstract void bulk(List<SetApiLorcast> sets, List<CardApiLorcast> cards);

    public abstract void bulkData(List<Card> cards);

    public abstract Card getCardById(String uniqueId);

    public abstract List<CardApiLorcast> getCards();

    public abstract List<SetApiLorcast> getSets();

    // public abstract List<Card> getCards();
}
