package cz.wrent.wswe.trelloDataImport.service;

import cz.wrent.wswe.model.Meal;
import cz.wrent.wswe.repository.MealRepository;
import cz.wrent.wswe.trelloDataImport.dto.BoardDTO;
import cz.wrent.wswe.trelloDataImport.trello.service.TrelloService;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DataImportServiceImpl implements DataImportService {

  private final TrelloService trelloService;
  private final MealRepository mealRepository;

  public DataImportServiceImpl(TrelloService trelloService,
      MealRepository mealRepository) {
    this.trelloService = trelloService;
    this.mealRepository = mealRepository;
  }

  @Override
  public Flux<BoardDTO> getAvailableBoards() {
    return trelloService.getBoards()
        .map(BoardDTO::map);
  }

  @Override
  public void importBoards(List<String> boardIds) {
    Flux<Meal> mealFlux = Flux.fromStream(boardIds.stream())
        .flatMap(trelloService::getCardsOnBoard)
        .map(Meal::fromCard);

    mealRepository.saveAll(mealFlux).subscribe();
  }
}
