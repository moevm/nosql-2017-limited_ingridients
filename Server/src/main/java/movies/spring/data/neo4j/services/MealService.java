package movies.spring.data.neo4j.services;


import movies.spring.data.neo4j.domain.Meal;
import movies.spring.data.neo4j.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Transactional()
    public void  createNewMeal(Long id,String label) {
        mealRepository.createNewMeal(id,label);
    }

    @Transactional(readOnly = true)
    public Collection<Meal> getAll(Long id) {
        return mealRepository.getAll(id);
    }

    @Transactional()
    public void deleteMeal(Long id, Long meal_id){
        mealRepository.deleteMeal(id,meal_id);
    }
}
