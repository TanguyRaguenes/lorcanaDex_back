package fr.app.lorcanaDex.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

import fr.app.lorcanaDex.bll.ICardsManager;
import fr.app.lorcanaDex.bo.Card;
import reactor.core.publisher.Mono;

@RestController
public class CardsController {

    private ICardsManager cardsManager;

    public CardsController(ICardsManager cardsManager) {
        this.cardsManager = cardsManager;
    }

    WebClient.Builder builder = WebClient.builder();

    @GetMapping("/bulk-data")
    // @CrossOrigin(origins = "http://localhost:4200")
    public Mono<String> bulkData() {

        String url = "https://api.lorcana-api.com/bulk/cards";

        return builder.build()
                .get()
                .uri(url)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        clientResponse -> Mono
                                .error(new RuntimeException("Client error: " + clientResponse.statusCode())))
                .onStatus(status -> status.is5xxServerError(),
                        clientResponse -> Mono
                                .error(new RuntimeException("Server error: " + clientResponse.statusCode())))
                .bodyToFlux(Card.class)
                .collectList()
                .flatMap(cardsList -> {
                    cardsManager.bulkData(cardsList);
                    return Mono.just("bulkData done");
                })
                .onErrorResume(e -> {
                    return Mono.just("Failed to process bulk data: " + e.getMessage());
                });
    }

    @GetMapping("/get-cards")
    // @CrossOrigin(origins = "http://localhost:4200")
    public List<Card> getCards() {

        return cardsManager.getCards();

    }
}
