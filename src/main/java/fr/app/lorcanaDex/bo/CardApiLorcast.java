package fr.app.lorcanaDex.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CardApiLorcast {

    // {
    // "id": "crd_d9f3b86af85f48579ed9d0d7ce0de129",
    // "name": "Ariel",
    // "version": "On Human Legs",
    // "layout": "normal",
    // "released_at": "2023-08-18",
    // "image_uris": {
    // "digital": {
    // "small":
    // "https://cards.lorcast.io/card/digital/small/crd_d9f3b86af85f48579ed9d0d7ce0de129.avif?1709690747",
    // "normal":
    // "https://cards.lorcast.io/card/digital/normal/crd_d9f3b86af85f48579ed9d0d7ce0de129.avif?1709690747",
    // "large":
    // "https://cards.lorcast.io/card/digital/large/crd_d9f3b86af85f48579ed9d0d7ce0de129.avif?1709690747"
    // }
    // },
    // "cost": 4,
    // "inkwell": true,
    // "ink": "Amber",
    // "type": [
    // "Character"
    // ],
    // "classifications": [
    // "Storyborn",
    // "Hero",
    // "Princess"
    // ],
    // "text": "VOICELESS This character can't {E} to sing songs.",
    // "keywords": [],
    // "move_cost": null,
    // "strength": 3,
    // "willpower": 4,
    // "lore": 2,
    // "rarity": "Uncommon",
    // "illustrators": [
    // "Matthew Robert Davies"
    // ],
    // "collector_number": "1",
    // "lang": "en",
    // "flavor_text": "“...”",
    // "tcgplayer_id": 494102,
    // "legalities": {
    // "core": "legal"
    // },
    // "set": {
    // "id": "set_7ecb0e0c71af496a9e0110e23824e0a5",
    // "code": "1",
    // "name": "The First Chapter"
    // },
    // "prices": {
    // "usd": "0.07",
    // "usd_foil": "0.48"
    // }
    // },

    private Long cardIdBdd;

    @JsonAlias("id")
    private String cardIdApi;

    private String name;
    private String version;
    private String layout;

    @JsonAlias("released_at")
    private Date releasedAt;

    @JsonAlias("image_uris")
    private ImageUrisApiLorcast imageUris;

    private Long cost;
    private Boolean inkwell;
    private String ink;
    private List<String> type;
    private List<String> classifications;
    private String text;
    private List<String> keywords;

    @JsonAlias("move_cost")
    private Long moveCost;

    private Long strength;
    private Long willpower;
    private Long lore;

    private String rarity;
    private List<String> illustrators;

    @JsonAlias("collector_number")
    private String collectorNumber;

    private String lang;

    @JsonAlias("flavor_text")
    private String flavorText;

    @JsonAlias("tcgplayer_id")
    private Long tcgplayerId;

    private LegalitiesApiLorcast legalities;
    private SetApiLorcast set;
    private PricesApiLorcast prices;

    // Constructeur par défaut
    public CardApiLorcast() {
    }

    // Constructeur avec tous les paramètres
    public CardApiLorcast(Long cardIdBdd, String cardIdApi, String name, String version, String layout, Date releasedAt,
            ImageUrisApiLorcast imageUris, Long cost, Boolean inkwell, String ink, List<String> type,
            List<String> classifications, String text, List<String> keywords, Long moveCost, Long strength,
            Long willpower, Long lore, String rarity, List<String> illustrators, String collectorNumber,
            String lang, String flavorText, Long tcgplayerId, LegalitiesApiLorcast legalities,
            SetApiLorcast set, PricesApiLorcast prices) {
        this.cardIdBdd = cardIdBdd;
        this.cardIdApi = cardIdApi;
        this.name = name;
        this.version = version;
        this.layout = layout;
        this.releasedAt = releasedAt;
        this.imageUris = imageUris;
        this.cost = cost;
        this.inkwell = inkwell;
        this.ink = ink;
        this.type = type;
        this.classifications = classifications;
        this.text = text;
        this.keywords = keywords;
        this.moveCost = moveCost;
        this.strength = strength;
        this.willpower = willpower;
        this.lore = lore;
        this.rarity = rarity;
        this.illustrators = illustrators;
        this.collectorNumber = collectorNumber;
        this.lang = lang;
        this.flavorText = flavorText;
        this.tcgplayerId = tcgplayerId;
        this.legalities = legalities;
        this.set = set;
        this.prices = prices;
    }

    // Getters et Setters
    public Long getCardIdBdd() {
        return cardIdBdd;
    }

    public void setCardIdBdd(Long cardIdBdd) {
        this.cardIdBdd = cardIdBdd;
    }

    public String getCardIdApi() {
        return cardIdApi;
    }

    public void setCardIdApi(String cardIdApi) {
        this.cardIdApi = cardIdApi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Date getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(Date releasedAt) {
        this.releasedAt = releasedAt;
    }

    public ImageUrisApiLorcast getImageUris() {
        return imageUris;
    }

    public void setImageUris(ImageUrisApiLorcast imageUris) {
        this.imageUris = imageUris;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Boolean getInkwell() {
        return inkwell;
    }

    public void setInkwell(Boolean inkwell) {
        this.inkwell = inkwell;
    }

    public String getInk() {
        return ink;
    }

    public void setInk(String ink) {
        this.ink = ink;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<String> classifications) {
        this.classifications = classifications;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Long getMoveCost() {
        return moveCost;
    }

    public void setMoveCost(Long moveCost) {
        this.moveCost = moveCost;
    }

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }

    public Long getWillpower() {
        return willpower;
    }

    public void setWillpower(Long willpower) {
        this.willpower = willpower;
    }

    public Long getLore() {
        return lore;
    }

    public void setLore(Long lore) {
        this.lore = lore;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public List<String> getIllustrators() {
        return illustrators;
    }

    public void setIllustrators(List<String> illustrators) {
        this.illustrators = illustrators;
    }

    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public Long getTcgplayerId() {
        return tcgplayerId;
    }

    public void setTcgplayerId(Long tcgplayerId) {
        this.tcgplayerId = tcgplayerId;
    }

    public LegalitiesApiLorcast getLegalities() {
        return legalities;
    }

    public void setLegalities(LegalitiesApiLorcast legalities) {
        this.legalities = legalities;
    }

    public SetApiLorcast getSet() {
        return set;
    }

    public void setSet(SetApiLorcast set) {
        this.set = set;
    }

    public PricesApiLorcast getPrices() {
        return prices;
    }

    public void setPrices(PricesApiLorcast prices) {
        this.prices = prices;
    }

    // Méthode toString pour le débogage
    @Override
    public String toString() {
        return "CardApiLorcast{" +
                "cardIdBdd=" + cardIdBdd +
                ", cardIdApi=" + cardIdApi +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", layout='" + layout + '\'' +
                ", releasedAt=" + releasedAt +
                ", imageUris=" + imageUris +
                ", cost=" + cost +
                ", inkwell=" + inkwell +
                ", ink='" + ink + '\'' +
                ", type=" + type +
                ", classifications=" + classifications +
                ", text='" + text + '\'' +
                ", keywords=" + keywords +
                ", moveCost=" + moveCost +
                ", strength=" + strength +
                ", willpower=" + willpower +
                ", lore=" + lore +
                ", rarity='" + rarity + '\'' +
                ", illustrators=" + illustrators +
                ", collectorNumber='" + collectorNumber + '\'' +
                ", lang='" + lang + '\'' +
                ", flavorText='" + flavorText + '\'' +
                ", tcgplayerId=" + tcgplayerId +
                ", legalities=" + legalities +
                ", set=" + set +
                ", prices=" + prices +
                '}';
    }

}