package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Dish_Type;
import movies.spring.data.neo4j.services.Dish_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController()
@RequestMapping("/dish_type")
public class Dish_TypeController {

    final Dish_TypeService dish_typeService;

    @Autowired
    public Dish_TypeController(Dish_TypeService dish_typeService) {
        this.dish_typeService = dish_typeService;
    }

    @RequestMapping("/new")
    public void  createNewRecept(@RequestParam(value = "mealLabel") String mealLabel,@RequestParam(value = "label") String label) {
        dish_typeService.createNewDish_Type(mealLabel,label);
    }

    @RequestMapping("/getAll")
    public Collection<Dish_Type> getAll(@RequestParam(value = "id") Long id) {
        return dish_typeService.getAll(id);
    }

}
