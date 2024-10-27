package fr.app.lorcanaDex.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import fr.app.lorcanaDex.bo.Card;

@RestController
@RequestMapping("/deck")
public class DeckController {

    @PostMapping("/{deckId}")
    public Map<String, List<Card>> saveDeckCardsInBdd(@PathVariable Integer deckId, @RequestBody List<Card> cards) {

        System.out.println("deckId" + deckId);
        System.out.println("cards" + cards);
        Map<String, List<Card>> response = new HashMap<>();
        response.put("back response", cards);
        return response;
    }

}
