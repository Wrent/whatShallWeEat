package cz.wrent.wswe.trelloDataImport.controller;

import cz.wrent.wswe.trelloDataImport.dto.BoardDTO;
import cz.wrent.wswe.trelloDataImport.dto.ResponseDTO;
import cz.wrent.wswe.trelloDataImport.service.DataImportService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/import/trello")
public class TrelloImportController {

  private final DataImportService dataImportService;

  public TrelloImportController(
      DataImportService dataImportService) {
    this.dataImportService = dataImportService;
  }

  @GetMapping("/availableBoards")
  public Flux<BoardDTO> getAvailableBoards() {
    return dataImportService.getAvailableBoards();
  }

  @PostMapping
  public ResponseDTO importBoards(@RequestBody List<String> boardIds) {
    dataImportService.importBoards(boardIds);
    return ResponseDTO.builder().isOk(true).build();
  }
}
