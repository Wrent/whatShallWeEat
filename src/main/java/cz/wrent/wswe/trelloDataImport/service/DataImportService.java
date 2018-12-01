package cz.wrent.wswe.trelloDataImport.service;

import cz.wrent.wswe.trelloDataImport.dto.BoardDTO;
import java.util.List;
import reactor.core.publisher.Flux;

public interface DataImportService {

  Flux<BoardDTO> getAvailableBoards();

  void importBoards(List<String> boardIds);
}
