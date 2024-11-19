package fr.app.lorcanaDex.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.app.lorcanaDex.bo.Card;
import fr.app.lorcanaDex.bo.CardApiLorcast;
import fr.app.lorcanaDex.bo.SetApiLorcast;
import fr.app.lorcanaDex.service.CloudinaryService;

@Repository
public class CardsDao implements ICardsDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private CloudinaryService cloudinaryService;
    private Integer i = 0;

    public CardsDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            CloudinaryService cloudinaryService) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void bulkData(List<Card> cards) {

        System.out.println("//////////////////////////////////////////////");
        System.out.println("nb cartes récupérées : " + cards.size());
        System.out.println("Début du bulk...");

        if (cards != null) {
            i = 0;
            cards.forEach(card -> {

                if (getCardById(card.getUniqueId()) != null) {
                    // System.out.println("La carte est déjà dans la BDD");
                } else {
                    // System.out.println("Il faut ajouter la carte à la BDD");

                    try {

                        String cloudinaryImageUrl = cloudinaryService.uploadImage(card.getImage());

                        // System.out.println("Carte numéro : " + i++);
                        // System.out.println(cloudinaryImageUrl);

                        String sql = "INSERT INTO cards(artist,lorcanaSetName,classifications,dateAdded,setNum,color,gamemode,franchise,image, imageSmall,cost,inkable,"
                                + "name,type,lore,rarity,flavorText,uniqueId,cardNum,bodyText,willpower,cardVariants,dateModified,strength,setId)"
                                + "VALUES (:artist,:lorcanaSetName,:classifications,:dateAdded,:setNum,:color,:gamemode,:franchise,:image,:imageSmall,:cost,:inkable,"
                                + ":name,:type,:lore,:rarity,:flavorText,:uniqueId,:cardNum,:bodyText,:willpower,:cardVariants,:dateModified,:strength,:setId)";
                        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
                        mapSqlParameterSource.addValue("artist", card.getArtist());
                        mapSqlParameterSource.addValue("lorcanaSetName", card.getLorcanaSetName());
                        mapSqlParameterSource.addValue("classifications", card.getClassifications());
                        mapSqlParameterSource.addValue("dateAdded", card.getDateAdded());
                        mapSqlParameterSource.addValue("setNum", card.getSetNum());
                        mapSqlParameterSource.addValue("color", card.getColor());
                        mapSqlParameterSource.addValue("gamemode", card.getGamemode());
                        mapSqlParameterSource.addValue("franchise", card.getFranchise());
                        mapSqlParameterSource.addValue("image", card.getImage());
                        mapSqlParameterSource.addValue("imageSmall", cloudinaryImageUrl); // URL de Cloudinary
                        mapSqlParameterSource.addValue("cost", card.getCost());
                        mapSqlParameterSource.addValue("inkable", card.isInkable());
                        mapSqlParameterSource.addValue("name", card.getName());
                        mapSqlParameterSource.addValue("type", card.getType());
                        mapSqlParameterSource.addValue("lore", card.getLore());
                        mapSqlParameterSource.addValue("rarity", card.getRarity());
                        mapSqlParameterSource.addValue("flavorText", card.getFlavorText());
                        mapSqlParameterSource.addValue("uniqueId", card.getUniqueId());
                        mapSqlParameterSource.addValue("cardNum", card.getCardNum());
                        mapSqlParameterSource.addValue("bodyText", card.getBodyText());
                        mapSqlParameterSource.addValue("willpower", card.getWillpower());
                        mapSqlParameterSource.addValue("cardVariants", card.getCardVariants());
                        mapSqlParameterSource.addValue("dateModified", card.getDateModified());
                        mapSqlParameterSource.addValue("strength", card.getStrength());
                        mapSqlParameterSource.addValue("setId", card.getSetId());

                        namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

            });

        }

        System.out.println("Fin du bulk !!!");
        System.out.println("//////////////////////////////////////////////");

    }

    @Override
    public Card getCardById(String uniqueId) {

        List<Card> cards = jdbcTemplate.query("SELECT * FROM cards WHERE uniqueId=?",
                new BeanPropertyRowMapper<Card>(Card.class), uniqueId);
        return cards.isEmpty() ? null : cards.get(0);
    }

    @Override
    public List<Card> getCards() {

        List<Card> cards = null;

        cards = jdbcTemplate.query("SELECT * FROM cards", new BeanPropertyRowMapper<Card>(Card.class));

        return cards;
    }

    @Override
    public void bulk(List<SetApiLorcast> sets, List<CardApiLorcast> cards) {

        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 0");
        jdbcTemplate.execute("TRUNCATE TABLE cards_api_lorcast");
        jdbcTemplate.execute("TRUNCATE TABLE sets_api_lorcast");
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 1");

        String sql = "INSERT INTO sets_Api_Lorcast ("
                + "setIdApi, name, code, releasedAt, prereleasedAt"
                + ") VALUES (?, ?, ?, ?, ?)";

        for (SetApiLorcast set : sets) {
            jdbcTemplate.update(sql,
                    set.getSetIdApi(),
                    set.getName(),
                    set.getCode(),
                    set.getReleasedAt(),
                    set.getPrereleasedAt());
        }

        sql = "INSERT INTO cards_Api_Lorcast ("
                + "cardIdApi, name, version, layout, releasedAt, "
                + "imageSmallUrl, imageNormalUrl, imageLargeUrl, cost, inkwell, "
                + "ink, type, classifications, text, keywords, "
                + "moveCost, strength, willpower, lore, rarity, "
                + "illustrators, collectorNumber, lang, flavorText, tcgplayerId, "
                + "legalityCore, setIdApi, setName, setCode, pricesUsd, pricesUsdFoil"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        for (CardApiLorcast card : cards) {

            jdbcTemplate.update(sql,
                    card.getCardIdApi(),
                    card.getName(),
                    card.getVersion(),
                    card.getLayout(),
                    card.getReleasedAt(),
                    card.getImageUris() != null && card.getImageUris().getDigital() != null
                            ? card.getImageUris().getDigital().getSmall()
                            : null,
                    card.getImageUris() != null && card.getImageUris().getDigital() != null
                            ? card.getImageUris().getDigital().getNormal()
                            : null,
                    card.getImageUris() != null && card.getImageUris().getDigital() != null
                            ? card.getImageUris().getDigital().getLarge()
                            : null,
                    card.getCost(),
                    card.getInkwell(),
                    card.getInk(),
                    card.getType() != null ? String.join(",", card.getType()) : null,
                    card.getClassifications() != null ? String.join(",", card.getClassifications()) : null,
                    card.getText(),
                    card.getKeywords() != null ? String.join(",", card.getKeywords()) : null,
                    card.getMoveCost(),
                    card.getStrength(),
                    card.getWillpower(),
                    card.getLore(),
                    card.getRarity(),
                    card.getIllustrators() != null ? String.join(",", card.getIllustrators()) : null,
                    card.getCollectorNumber(),
                    card.getLang(),
                    card.getFlavorText(),
                    card.getTcgplayerId(),
                    card.getLegalities() != null ? card.getLegalities().getCore() : null,
                    card.getSet() != null ? card.getSet().getSetIdApi() : null,
                    card.getSet() != null ? card.getSet().getName() : null,
                    card.getSet() != null ? card.getSet().getCode() : null,
                    card.getPrices() != null ? card.getPrices().getUsd() : null,
                    card.getPrices() != null ? card.getPrices().getUsdFoil() : null);
        }

    }

    @Override
    public List<CardApiLorcast> get() {

        List<CardApiLorcast> cards = new ArrayList<CardApiLorcast>();

        cards = jdbcTemplate.query("SELECT * FROM cards_api_lorcast",
                new BeanPropertyRowMapper<CardApiLorcast>(CardApiLorcast.class));

        return cards;
    }

}
