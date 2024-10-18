package fr.app.lorcanaDex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.app.lorcanaDex.bll.DeckManager;
import fr.app.lorcanaDex.bo.Deck;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/decks")
public class DecksController {

    private DeckManager deckManager;

    public DecksController(DeckManager deckManager) {
        this.deckManager = deckManager;
    }

    @PostMapping("")
    public Map<String, Deck> addDeckToBdd(@RequestBody Deck deck) {

        Map<String, Deck> response = new HashMap<>();
        deckManager.addDeckToBdd(deck);
        response.put("response", deck);

        return response;
    }

    @GetMapping("")
    public Map<String, String> getDecksByUserName() {

        Map<String, String> response = new HashMap<>();
        response.put("response", "coucou du back GET !");
        return response;

    }

}
