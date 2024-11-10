package fr.app.lorcanaDex.dao;

import java.util.HashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class DeckDao implements IDeckDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DeckDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // AJOUTER DES CARTES AU DECK

    @Override
    public void addCardsToDeck(Integer deckId, Map<Integer, Integer> cardsAndQuantity) {

        if (deckId != null) {

            // ON COMMENCE PAR VIDER LE DECK

            this.deleteDeckCards(deckId);

            cardsAndQuantity.forEach((cardId, quantity) -> {

                try {

                    jdbcTemplate.update(
                            "INSERT INTO deckDetails(deckId,cardId,quantity) VALUES (:deckId,:cardId,:quantity)",
                            deckId, cardId, quantity);

                } catch (DataAccessException e) {
                    throw new RuntimeException("Error sql request addCardsToDeck" + e.getMessage() + e);
                }

            });

        }

        return;

    }

    // RECUPERER LES CARTES DU DECK

    @Override
    public Map<Integer, Integer> getDeckCards(Integer deckId) {

        Map<Integer, Integer> cards = new HashMap<>();

        jdbcTemplate.query("SELECT cardId, quantity FROM deckDetails WHERE deckId = ?",
                rs -> {
                    cards.put(rs.getInt("cardId"), rs.getInt("quantity"));
                },
                deckId);

        System.out.println(cards);

        return cards;
    }

    // SUPPRIMER LES CARTES DU DECK

    public void deleteDeckCards(Integer deckId) {

        try {

            jdbcTemplate.update("DELETE FROM deckDetails WHERE deckId = ?", deckId);

        } catch (DataAccessException e) {
            throw new RuntimeException("Error sql request deleteDeckCards : " + e.getMessage(), e);
        }

    }

}
