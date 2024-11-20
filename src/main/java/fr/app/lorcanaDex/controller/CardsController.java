package fr.app.lorcanaDex.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.app.lorcanaDex.bll.ICardsManager;
import fr.app.lorcanaDex.bo.Card;
import fr.app.lorcanaDex.bo.CardApiLorcast;
import fr.app.lorcanaDex.bo.SetApiLorcast;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cards")
public class CardsController {

    private ICardsManager cardsManager;
    private WebClient.Builder builder;
    private Environment environment;

    public CardsController(ICardsManager cardsManager, WebClient.Builder builder, Environment environment) {
        this.cardsManager = cardsManager;
        this.builder = builder;
        this.environment = environment;
    }

    @GetMapping("/bulk")
    public Map<String, String> bulk() {

        List<CardApiLorcast> cards = new ArrayList<CardApiLorcast>();

        Map<String, String> response = new HashMap<String, String>();

        List<SetApiLorcast> sets = builder.build()
                .get()
                .uri(environment.getProperty("lorcast.Url.GetSets"))
                // .uri("https://api.lorcast.com/v0/sets")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, List<SetApiLorcast>>>() {
                })
                .map(resultMap -> resultMap.get("results")) // Extraire "results"
                .block(); // Attendre la réponse

        for (SetApiLorcast set : sets) {

            List<CardApiLorcast> setCards = builder.build()
                    .get()
                    .uri(environment.getProperty("lorcast.Url.GetCardsBySet"), set.getCode())
                    // .uri("https://api.lorcast.com/v0/sets/{code}/cards", set.getCode())
                    .retrieve()
                    .bodyToFlux(CardApiLorcast.class)
                    .collectList()
                    .block();

            cards.addAll(setCards);

        }

        // for (CardApiLorcast card : allCards) {
        // System.out.println(card.toString());
        // System.out.println();
        // System.out.println();
        // }

        cardsManager.bulk(sets, cards);

        response.put("Back response", "Bulk success");
        return response;

        // String url = "https://api.lorcana-api.com/bulk/cards";

        // return builder.build()
        // .get()
        // .uri(url)
        // .retrieve()
        // .onStatus(status -> status.is4xxClientError(),
        // clientResponse -> Mono
        // .error(new RuntimeException("Client error: " + clientResponse.statusCode())))
        // .onStatus(status -> status.is5xxServerError(),
        // clientResponse -> Mono
        // .error(new RuntimeException("Server error: " + clientResponse.statusCode())))
        // .bodyToFlux(Card.class)
        // .collectList()
        // .flatMap(cardsList -> {
        // cardsManager.bulkData(cardsList);
        // Map<String, String> response = new HashMap<>();
        // response.put("message", "bulkData done");
        // return Mono.just(response);
        // })
        // .onErrorResume(e -> {
        // Map<String, String> response = new HashMap<>();
        // response.put("message", "Failed to process bulk data: " + e.getMessage());
        // return Mono.just(response);
        // });
    }

    @GetMapping("/getCards")
    public List<CardApiLorcast> getCards() {

        return cardsManager.getCards();

    }

    @GetMapping("/getSets")
    public List<SetApiLorcast> getSets() {

        return cardsManager.getSets();

    }

    // @GetMapping("/get-cards")
    // public List<Card> getCardsa() {

    // return cardsManager.getCards();

    // }
}
