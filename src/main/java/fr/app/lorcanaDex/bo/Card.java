package fr.app.lorcanaDex.bo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {

    // Artist": "Evana Kisa, Jochem van Gool",
    // "Set_Name": "Into the Inklands",
    // "Classifications": "Storyborn, Villain",
    // "Date_Added": "2024-02-23T12:00",
    // "Set_Num": 3,
    // "Color": "Amber",
    // "Gamemode": "Lorcana",
    // "Franchise": "",
    // "Image":
    // "https://lorcana-api.com/images/chernabog/evildoer/chernabog-evildoer-large.png",
    // "Cost": 10,
    // "Inkable": false,
    // "Name": "Chernabog - Evildoer",
    // "Type": "Character",
    // "Lore": 3,
    // "Rarity": "Super Rare",
    // "Flavor_Text": "Darkness calls to minions everywhere",
    // "Unique_ID": "INK-003",
    // "Card_Num": 3,
    // "Body_Text": "The Power Of Evil - For each character card in your discard,
    // you pay 1{i} less to play this character.\n\nSummon The Spirits - When you
    // play this character, shuffle all character cards from your discard into your
    // deck.",
    // "Willpower": 9,
    // "Card_Variants": "(enchanted, placeholder)",
    // "Date_Modified": "2024-07-01 19:27:17.0",
    // "Strength": 9,
    // "Set_ID": "INK"

    // @JsonProperty("Artist")
    @JsonAlias({ "Artist", "artist" })
    private String artist;

    @JsonAlias({ "Set_Name", "lorcanaSetName" })
    private String lorcanaSetName;

    @JsonAlias({ "Classifications", "classifications" })
    private String classifications;

    @JsonAlias({ "Date_Added", "dateAdded" })
    private String dateAdded;

    @JsonAlias({ "Set_Num", "setNum" })
    private Long setNum;

    @JsonAlias({ "Color", "color" })
    private String color;

    @JsonAlias({ "Gamemode", "gamemode" })
    private String gamemode;

    @JsonAlias({ "Franchise", "franchise" })
    private String franchise;

    @JsonAlias({ "Image", "image" })
    private String image;

    @JsonAlias({ "ImageSmall", "imageSmall" })
    private String imageSmall;

    @JsonAlias({ "Cost", "cost" })
    private Long cost;

    @JsonAlias({ "Inkable", "inkable" })
    private boolean inkable;

    @JsonAlias({ "Name", "name" })
    private String name;

    @JsonAlias({ "Type", "type" })
    private String type;

    @JsonAlias({ "Lore", "lore" })
    private Long lore;

    @JsonAlias({ "Rarity", "rarity" })
    private String rarity;

    @JsonAlias({ "Flavor_Text", "flavorText" })
    private String flavorText;

    @JsonAlias({ "Unique_ID", "uniqueId" })
    private String uniqueId;

    @JsonAlias({ "Card_Num", "cardNum" })
    private Long cardNum;

    @JsonAlias({ "Body_Text", "bodyText" })
    private String bodyText;

    @JsonAlias({ "Willpower", "willpower" })
    private Long willpower;

    @JsonAlias({ "Card_Variants", "cardVariants" })
    private String cardVariants;

    @JsonAlias({ "Date_Modified", "dateModified" })
    private String dateModified;

    @JsonAlias({ "Strength", "strength" })
    private Long strength;

    @JsonAlias({ "Set_ID", "setId" })
    private String setId;

    public Card() {
        super();
    }

    public Card(String artist, String lorcanaSetName, String classifications, String dateAdded, Long setNum,
            String color,
            String gamemode, String franchise, String image, String imageSmall, Long cost, boolean inkable, String name,
            String type,
            Long lore, String rarity, String flavorText, String uniqueId, Long cardNum, String bodyText, Long willpower,
            String cardVariants, String dateModified, Long strength, String setId) {
        this.artist = artist;
        this.lorcanaSetName = lorcanaSetName;
        this.classifications = classifications;
        this.dateAdded = dateAdded;
        this.setNum = setNum;
        this.color = color;
        this.gamemode = gamemode;
        this.franchise = franchise;
        this.image = image;
        this.imageSmall = imageSmall;
        this.cost = cost;
        this.inkable = inkable;
        this.name = name;
        this.type = type;
        this.lore = lore;
        this.rarity = rarity;
        this.flavorText = flavorText;
        this.uniqueId = uniqueId;
        this.cardNum = cardNum;
        this.bodyText = bodyText;
        this.willpower = willpower;
        this.cardVariants = cardVariants;
        this.dateModified = dateModified;
        this.strength = strength;
        this.setId = setId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLorcanaSetName() {
        return lorcanaSetName;
    }

    public void setLorcanaSetName(String lorcanaSetName) {
        this.lorcanaSetName = lorcanaSetName;
    }

    public String getClassifications() {
        return classifications;
    }

    public void setClassifications(String classifications) {
        this.classifications = classifications;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Long getSetNum() {
        return setNum;
    }

    public void setSetNum(Long setNum) {
        this.setNum = setNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGamemode() {
        return gamemode;
    }

    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public boolean isInkable() {
        return inkable;
    }

    public void setInkable(boolean inkable) {
        this.inkable = inkable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Long getCardNum() {
        return cardNum;
    }

    public void setCardNum(Long cardNum) {
        this.cardNum = cardNum;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public Long getWillpower() {
        return willpower;
    }

    public void setWillpower(Long willpower) {
        this.willpower = willpower;
    }

    public String getCardVariants() {
        return cardVariants;
    }

    public void setCardVariants(String cardVariants) {
        this.cardVariants = cardVariants;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    @Override
    public String toString() {
        return "Card [artist=" + artist + ", setName=" + lorcanaSetName + ", classifications=" + classifications
                + ", dateAdded=" + dateAdded + ", setNum=" + setNum + ", color=" + color + ", gamemode=" + gamemode
                + ", franchise=" + franchise + ", image=" + image + ", cost=" + cost + ", inkable=" + inkable
                + ", name=" + name + ", type=" + type + ", lore=" + lore + ", rarity=" + rarity + ", flavorText="
                + flavorText + ", uniqueId=" + uniqueId + ", cardNum=" + cardNum + ", bodyText=" + bodyText
                + ", willpower=" + willpower + ", cardVariants=" + cardVariants + ", dateModified=" + dateModified
                + ", strength=" + strength + ", setId=" + setId + "]";
    }

}
