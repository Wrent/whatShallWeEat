package cz.wrent.wswe.trelloDataImport.trello.service;

import cz.wrent.wswe.trelloDataImport.trello.dto.Board;
import cz.wrent.wswe.trelloDataImport.trello.dto.Card;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class TrelloService {

  private final WebClient webClient;
  private final URLBuilder urlBuilder;

  public TrelloService(WebClient webClient,
      URLBuilder urlBuilder) {
    this.webClient = webClient;
    this.urlBuilder = urlBuilder;
  }

  public Flux<Board> getBoards() {
    return getFlux(urlBuilder.getMyBoards(), Board.class);
  }

  public Flux<Card> getCardsOnBoard(String id) {
    return getFlux(urlBuilder.getCardsOnBoard(id), Card.class);
  }

  private <T> Flux<T> getFlux(String url, Class<T> clazz) {
    return webClient.get()
        .uri(url)
        .exchange()
        .flatMapMany(response -> response.bodyToFlux(clazz));
  }
}
