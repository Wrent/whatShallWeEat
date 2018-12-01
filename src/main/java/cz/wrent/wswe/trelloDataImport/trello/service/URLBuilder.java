package cz.wrent.wswe.trelloDataImport.trello.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class URLBuilder {

  private final static String DELIMITER = "/";

  private final String myBoards;
  private final String boards;
  private final String cards;
  private final String suffix;

  URLBuilder(@Value("${trello.url.my-boards}") String myBoards,
      @Value("${trello.url.boards}") String boards,
      @Value("${trello.url.cards}") String cards,
      @Value("${trello.url.suffix}") String suffix) {
    this.myBoards = myBoards;
    this.boards = boards;
    this.cards = cards;
    this.suffix = suffix;
  }

  String getMyBoards() {
    return addSuffix(myBoards);
  }

  String getCardsOnBoard(String id) {
    return addSuffix(boards + id + DELIMITER + cards);
  }

  private String addSuffix(String prefix) {
    return prefix + suffix;
  }
}
