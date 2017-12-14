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

    @RequestMapping("/getAllfromType")
    public Collection<Ingredient> getAllfromType(@RequestParam(value = "id") Long id) {
        Collection<Ingredient> allfromType = ingredientService.getAllfromType(id);

        for (Ingredient ingr :allfromType) {
            ingr.setTypeLabel(ingr.getType().getLabel());
            ingr.setType(null);
        }

        return allfromType;
    }

    @RequestMapping("/getAll")
    public Collection<Ingredient> getAll(@RequestParam(value = "id") Long id) {
        return ingredientService.getAll(id);
    }

    @RequestMapping("/newInRecept")
    public void  createNewReceptIngredient(@RequestParam(value = "receptlabel") String receptlabel,@RequestParam(value = "label") String label,@RequestParam(value = "weight") Double weight,@RequestParam(value = "measure") String measure) {
        ingredientService.createNewReceptIngredient(receptlabel,label,weight,measure);
    }

    @RequestMapping("/addWeight")
    public void addSomeWeight(@RequestParam(value = "type_label") String type_label, @RequestParam(value = "ingr_label") String ingr_label,@RequestParam(value = "weight") Double weight){
        ingredientService.addSomeWeight(type_label,ingr_label,weight);
    }

    @RequestMapping("/getAllfromRecept")
    public Collection<Ingredient> getAllfromRecept(@RequestParam(value = "id") Long id) {
        return ingredientService.getAllfromRecept(id);
    }

}
