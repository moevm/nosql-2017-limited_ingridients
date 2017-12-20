package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Ingr_Type;
import movies.spring.data.neo4j.services.Ingr_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController()
@RequestMapping("/ingr_type")
public class Ingr_TypeController {

    final Ingr_TypeService ingr_typeService;

    @Autowired
    public Ingr_TypeController(Ingr_TypeService ingr_typeService) {
        this.ingr_typeService = ingr_typeService;
    }

    @RequestMapping("/new")
    public void newIngr_Type(@RequestParam(value = "userID") String userID,@RequestParam(value = "label") String label) {
        ingr_typeService.createNewIngr_Type(userID == null ? "Standard" : userID,label == null ? "Standard" : label);
    }

    @RequestMapping("/getAll")
    public Collection<Ingr_Type> getAll(@RequestParam(value = "id") Long id) {
        return ingr_typeService.getAll(id);
    }

    @RequestMapping("/delete")
    public void deleteIngr_type(@RequestParam(value = "fridegID") Long fridegID, @RequestParam(value = "ingr_type_ID") Long ingr_type_ID){
        ingr_typeService.deleteIngr_type(fridegID,ingr_type_ID);
    }
}
