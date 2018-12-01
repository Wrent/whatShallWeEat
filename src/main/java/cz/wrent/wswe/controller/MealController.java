package cz.wrent.wswe.controller;

import cz.wrent.wswe.model.Meal;
import cz.wrent.wswe.service.MealService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/meal")
public class MealController {

  private final MealService mealService;

  public MealController(MealService mealService) {
    this.mealService = mealService;
  }

  @GetMapping
  public Flux<Meal> getMeals() {
    return mealService.getMeals();
  }

}
