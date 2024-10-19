package fr.app.lorcanaDex.dao;

import java.util.List;

import fr.app.lorcanaDex.bo.Deck;

public interface IDecksDao {

    public void addDeckToBdd(Deck deck);

    public List<Deck> getDecksFromBdd(String username);

}
