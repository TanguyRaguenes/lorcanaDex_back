package fr.app.lorcanaDex.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.app.lorcanaDex.bo.Deck;
import fr.app.lorcanaDex.service.CloudinaryService;

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

            System.out.println(deck.toString());

            String sql = "INSERT INTO decks(deckName,userName,creationDate,firstInk,secondInk)"
                    + "VALUES (:deckName,:userName,:creationDate,:firstInk,:secondInk)";
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("deckName", deck.getDeckName());
            mapSqlParameterSource.addValue("userName", deck.getUserName());
            mapSqlParameterSource.addValue("creationDate", deck.getCreationDate());
            mapSqlParameterSource.addValue("firstInk", deck.getFirstInk());
            mapSqlParameterSource.addValue("secondInk", deck.getSecondInk());

            namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);

        }

        return;
    }

}
