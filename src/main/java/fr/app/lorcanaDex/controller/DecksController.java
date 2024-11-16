package fr.app.lorcanaDex.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import fr.app.lorcanaDex.bll.IDecksManager;
import fr.app.lorcanaDex.bo.Deck;
import fr.app.lorcanaDex.security.JwtUtil;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/decks")
public class DecksController {

    // ATTRIBUTS

    private IDecksManager decksManager;
    private JwtUtil jwtUtil;

    // CONSTRUCTEUR

    public DecksController(IDecksManager decksManager, JwtUtil jwtUtil) {
        this.decksManager = decksManager;
        this.jwtUtil = jwtUtil;
    }

    // WebClient.Builder builder = WebClient.builder();

    // METHODES

    @PostMapping("")
    public Map<String, Deck> addDeckToBdd(@RequestBody Deck deck) {

        Map<String, Deck> response = new HashMap<>();
        decksManager.addDeckToBdd(deck);
        response.put("response", deck);

        return response;
    }

    @GetMapping("")
    public List<Deck> getDecksFromBdd(@RequestHeader("Authorization") String token) {

        String jwtToken = token.substring(7);
        String username = jwtUtil.extractUsername(jwtToken);
        System.out.println("Voici le username récupéré à partir du jwtToken " + username);

        List<Deck> decks = new ArrayList<>();

        if (username != null && !username.isEmpty()) {

            decks = decksManager.getDecksFromBdd(username);

        } else {
            throw new IllegalArgumentException("Le nom d'utilisateur ne peut pas être nul ou vide");
        }

        return decks;

    }

    @DeleteMapping("")
    public ResponseEntity<Map<String, String>> removeDeckFromBdd(@RequestParam Integer deckId) {

        Map<String, String> response = new HashMap<>();

        try {
            decksManager.removeDeckFromBDD(deckId);
            response.put("response", "Suppression réussie du deck avec l'ID " + deckId);
            return ResponseEntity.ok(response);
        } catch (EmptyResultDataAccessException e) {
            response.put("error", "Deck avec l'ID " + deckId + " introuvable.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (DataAccessException e) {
            response.put("error", "Erreur de base de données lors de la suppression du deck : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } catch (Exception e) {
            response.put("error", "Une erreur inattendue est survenue : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

}
