package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Ingredient;
import movies.spring.data.neo4j.domain.Recept;
import movies.spring.data.neo4j.services.Ingr_TypeService;
import movies.spring.data.neo4j.services.IngredientService;
import movies.spring.data.neo4j.services.ReceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController()
@RequestMapping("/recept")
public class ReceptController {

    final ReceptService receptService;
    final Ingr_TypeService ingr_typeService;
    final IngredientService ingredientService;

    @Autowired
    public ReceptController(ReceptService receptService, Ingr_TypeService ingr_typeService,IngredientService ingredientService) {
        this.receptService = receptService;
        this.ingr_typeService = ingr_typeService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping("/new")
    public void  createNewRecept(@RequestParam(value = "id") Long id,@RequestParam(value = "label") String label,@RequestParam(value = "time") Long time,@RequestParam(value = "someSubs") String someSubs) {
        receptService.createNewRecept(id,label,time,someSubs);
    }

    @RequestMapping("/getAll")
    public Collection<Recept> getAll(Long id) {
        return receptService.getAll(id);
    }

    @RequestMapping("/getByID")
    public Recept getByID(Long id) {
        return receptService.getByID(id);
    }

    @RequestMapping("/checkReceptByID")
    public boolean checkReceptByID(@RequestParam(value = "id") Long id, @RequestParam(value = "fridgeid") Long fridgeid){
        Recept recept = receptService.getByID(id);

        if(recept.getIngredients()==null) return true;
        int ingrs = recept.getIngredients().size();

        List<Ingredient> allIngrs = (List<Ingredient>) ingredientService.getAll(fridgeid);

        for(Ingredient ingrInAll: allIngrs){
            for(Ingredient ingr :recept.getIngredients()){
                if(ingrInAll.getLabel().equals(ingr.getLabel())){
                    if(ingrInAll.getWeight()>=ingr.getWeight()) ingrs--;
                }
            }
        }

        return (ingrs<=0);
    }

    @RequestMapping("/buyRecept")
    public void buyRecept(@RequestParam(value = "id") Long id,@RequestParam(value = "fridgeid") Long fridgeid){
        Recept recept = receptService.getByID(id);

        int ingrs = recept.getIngredients().size();

        List<Ingredient> allIngrs = (List<Ingredient>) ingredientService.getAll(fridgeid);

        for(Ingredient ingrInAll: allIngrs){
            for(Ingredient ingr :recept.getIngredients()){
                if(ingrInAll.getLabel().equals(ingr.getLabel())){
                    ingredientService.addSomeWeight(ingrInAll.getType().getLabel(),ingrInAll.getLabel(),(-1)*ingr.getWeight());
                }
            }
        }
    }

    @RequestMapping("/delete")
    public void deleteRecept(Long id, Long recept_id){
        receptService.deleteRecept(id,recept_id);
    }
}
