package fr.app.lorcanaDex.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.app.lorcanaDex.bll.IDecksManager;
import fr.app.lorcanaDex.bo.Deck;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/decks")
public class DecksController {

    // ATTRIBUTS

    private IDecksManager decksManager;

    // CONSTRUCTEUR

    public DecksController(IDecksManager decksManager) {
        this.decksManager = decksManager;
    }

    // METHODES

    @PostMapping("")
    public Map<String, Deck> addDeckToBdd(@RequestBody Deck deck) {

        Map<String, Deck> response = new HashMap<>();
        decksManager.addDeckToBdd(deck);
        response.put("response", deck);

        return response;
    }

    @GetMapping("")
    public List<Deck> getDecksFromBdd(@RequestHeader("username") String username) {

        List<Deck> decks = new ArrayList<>();

        if (username != null && !username.isEmpty()) {

            decks = decksManager.getDecksFromBdd(username);

        } else {
            throw new IllegalArgumentException("Le nom d'utilisateur ne peut pas être nul ou vide");
        }

        return decks;

    }

    @DeleteMapping("")
    public Map<String, String> deleteDeck(@RequestBody String username, @RequestBody String deckName) {

        Map<String, String> response = new HashMap<>();

        if (username != null && deckName != null) {

            response.put("response", username + "_" + deckName);

        } else {
            response.put("response", "fail");
        }

        return response;

    }

}
