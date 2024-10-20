package fr.app.lorcanaDex.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.app.lorcanaDex.bo.Card;
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

}
