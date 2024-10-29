package fr.app.lorcanaDex.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import fr.app.lorcanaDex.bll.IDeckManager;
import fr.app.lorcanaDex.bo.Card;

@RestController
@RequestMapping("/deck")
public class DeckController {

    private IDeckManager deckManager;

    public DeckController(IDeckManager deckManager) {
        this.deckManager = deckManager;
    }

    @PostMapping("/{deckId}")
    public Map<String, Map<Integer, Integer>> saveDeckCardsInBdd(@PathVariable Integer deckId,
            @RequestBody Map<Integer, Integer> cardsAndQuantity) {

        System.out.println("deckId" + deckId);
        System.out.println("cardsAndQuantity" + cardsAndQuantity);
        deckManager.addCardsToDeck(deckId, cardsAndQuantity);
        Map<String, Map<Integer, Integer>> response = new HashMap<>();
        response.put("back response", cardsAndQuantity);
        return response;
    }

}
