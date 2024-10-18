package fr.app.lorcanaDex.bo;

import java.util.Date;
import java.util.List;

public class Deck {

    private Long deckId;
    private String deckName;
    private String username;
    private Date creationDate;
    private Date updateDate;
    private String firstInk;
    private String secondInk;
    private List<Card> cardsArray;
    
    public Deck(Long deckId, String deckName, String username, Date creationDate, Date updateDate, String firstInk,
            String secondInk, List<Card> cardsArray) {
        this.deckId = deckId;
        this.deckName = deckName;
        this.username = username;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.firstInk = firstInk;
        this.secondInk = secondInk;
        this.cardsArray = cardsArray;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getFirstInk() {
        return firstInk;
    }

    public void setFirstInk(String firstInk) {
        this.firstInk = firstInk;
    }

    public String getSecondInk() {
        return secondInk;
    }

    public void setSecondInk(String secondInk) {
        this.secondInk = secondInk;
    }

    public List<Card> getCardsArray() {
        return cardsArray;
    }

    public void setCardsArray(List<Card> cardsArray) {
        this.cardsArray = cardsArray;
    }

    @Override
    public String toString() {
        return "Deck [deckId=" + deckId + ", deckName=" + deckName + ", username=" + username + ", creationDate="
                + creationDate + ", updateDate=" + updateDate + ", firstInk=" + firstInk + ", secondInk=" + secondInk
                + ", cardsArray=" + cardsArray + "]";
    }

    


}
