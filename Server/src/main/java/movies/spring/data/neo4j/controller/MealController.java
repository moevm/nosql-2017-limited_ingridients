package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Meal;
import movies.spring.data.neo4j.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController()
@RequestMapping("/meal")
public class MealController {

    final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @RequestMapping("/new")
    public void  createNewMeal(@RequestParam(value = "id")  Long id,@RequestParam(value = "label")  String label) {
        mealService.createNewMeal(id,label);
    }

    @RequestMapping("/getAll")
    public Collection<Meal> getAll(@RequestParam(value = "id") Long id) {
        return mealService.getAll(id);
    }

}
