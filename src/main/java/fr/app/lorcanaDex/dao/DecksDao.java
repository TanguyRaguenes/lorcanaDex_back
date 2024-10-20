package fr.app.lorcanaDex.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.app.lorcanaDex.bo.Deck;

@Repository
public class DecksDao implements IDecksDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DecksDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addDeckToBdd(Deck deck) {

        if (deck != null) {

            try {
                String sql = "INSERT INTO decks(deckName,username,creationDate,firstInk,secondInk)"
                        + "VALUES (:deckName,:userName,:creationDate,:firstInk,:secondInk)";
                MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
                mapSqlParameterSource.addValue("deckName", deck.getDeckName());
                mapSqlParameterSource.addValue("userName", deck.getUsername());
                mapSqlParameterSource.addValue("creationDate", deck.getCreationDate());
                mapSqlParameterSource.addValue("firstInk", deck.getFirstInk());
                mapSqlParameterSource.addValue("secondInk", deck.getSecondInk());

                namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);

            } catch (DataAccessException e) {
                throw new RuntimeException("Erreur avec la requête SQL" + e.getMessage() + e);
            }

        }

        return;
    }

    @Override
    public List<Deck> getDecksFromBdd(String username) {

        List<Deck> decks = new ArrayList<>();
        try {
            decks = jdbcTemplate.query("SELECT * FROM db_lorcanadex.decks WHERE username = ?",
                    new BeanPropertyRowMapper<Deck>(Deck.class), username);
        } catch (DataAccessException e) {
            throw new RuntimeException("Erreur avec la requête SQL" + e.getMessage() + e);
        }

        return decks;
    }

    @Override
    public void removeDeckFromBDD(Integer deckId) {
        final String sql = "DELETE FROM decks WHERE deckId = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, deckId);
            if (rowsAffected == 0) {
                throw new EmptyResultDataAccessException("No deck found with ID " + deckId, 1);
            }
        } catch (DataAccessException e) {
            throw new RuntimeException("Erreur avec la requête SQL " + e.getMessage(), e);
        }
    }

}
