package cz.wrent.wswe.dataImport.trello.service;

import cz.wrent.wswe.dataImport.trello.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class TrelloImportService {

    private final WebClient webClient;

    public TrelloImportService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Board> getBoards() {
        return webClient.get().exchange().block().bodyToFlux(Board.class);
    }

}
