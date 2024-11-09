package fr.app.lorcanaDex.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.Map;

import fr.app.lorcanaDex.bo.Card;

@Repository
public class DeckDao implements IDeckDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DeckDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addCardsToDeck(Integer deckId, Map<Integer, Integer> cardsAndQuantity) {

        if (deckId != null) {

            this.deleteDeckCards(deckId);

            cardsAndQuantity.forEach((cardId, quantity) -> {

                try {
                    String sql = "INSERT INTO deckDetails(deckId,cardId,quantity) VALUES (:deckId,:cardId,:quantity)";
                    MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
                    mapSqlParameterSource.addValue("deckId", deckId);
                    mapSqlParameterSource.addValue("cardId", cardId);
                    mapSqlParameterSource.addValue("quantity", quantity);

                    namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);

                } catch (DataAccessException e) {
                    throw new RuntimeException("Erreur avec la requête SQL" + e.getMessage() + e);
                }

            });

        }

        return;

    }

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

    public void deleteDeckCards(Integer deckId) {

        final String sql = "DELETE FROM deckDetails WHERE deckId = ?";

        try {

            jdbcTemplate.update(sql, deckId);

        } catch (DataAccessException e) {
            throw new RuntimeException("Error sql request deleteDeckCards : " + e.getMessage(), e);
        }

    }

}
