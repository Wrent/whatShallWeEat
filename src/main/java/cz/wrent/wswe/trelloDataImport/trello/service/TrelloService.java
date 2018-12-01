package cz.wrent.wswe.trelloDataImport.trello.service;

import cz.wrent.wswe.trelloDataImport.trello.dto.Board;
import cz.wrent.wswe.trelloDataImport.trello.dto.Card;
import reactor.core.publisher.Flux;

public interface TrelloService {

  Flux<Board> getBoards();

  Flux<Card> getCardsOnBoard(String id);
}
