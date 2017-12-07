package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Ingredient;
import movies.spring.data.neo4j.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController()
@RequestMapping("/ingredient")
public class IngredientController {

    final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping("/new")
    public void newIngr_Type(@RequestParam(value = "typeLabel") String typeLabel, @RequestParam(value = "label") String label,
                             @RequestParam(value = "weight",required = false) Double weight, @RequestParam(value = "measure") String measure) {
        ingredientService.createNewIngredient(typeLabel,label,(weight==null) ? 0 : weight,measure);
    }

    @RequestMapping("/getAll")
    public Collection<Ingredient> getIngrs(@RequestParam(value = "id") Long id) {
        return ingredientService.getAll(id);
    }

    @RequestMapping("/newInRecept")
    public void  createNewReceptIngredient(@RequestParam(value = "receptLabel") String receptlabel,@RequestParam(value = "label") String label,@RequestParam(value = "weight") Double weight,@RequestParam(value = "measure") String measure) {
        ingredientService.createNewReceptIngredient(receptlabel,label,weight,measure);
    }

    @RequestMapping("/addWeight")
    public void addSomeWeight(@RequestParam(value = "ingrID") Long ingrID,@RequestParam(value = "weight") Double weight){
        ingredientService.addSomeWeight(ingrID,weight);
    }

    @RequestMapping("/getAllRecept")
    public Collection<Ingredient> getAllRecept(@RequestParam(value = "id") Long id) {
        return ingredientService.getAllRecept(id);
    }

}
