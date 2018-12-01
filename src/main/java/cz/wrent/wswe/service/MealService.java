package cz.wrent.wswe.service;

import cz.wrent.wswe.model.Meal;
import cz.wrent.wswe.repository.MealRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MealService {

  private final MealRepository mealRepository;

  public MealService(MealRepository mealRepository) {
    this.mealRepository = mealRepository;
  }

  public Flux<Meal> getMeals() {
    return mealRepository.findAll();
  }
}
