package cz.wrent.wswe.repository;

import cz.wrent.wswe.model.Meal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends ReactiveMongoRepository<Meal, String> {

}
