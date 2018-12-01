package cz.wrent.wswe.service;

import cz.wrent.wswe.model.Meal;
import reactor.core.publisher.Flux;

public interface MealService {

  Flux<Meal> getMeals();
}
