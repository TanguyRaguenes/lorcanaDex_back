package fr.app.lorcanaDex.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
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

}
