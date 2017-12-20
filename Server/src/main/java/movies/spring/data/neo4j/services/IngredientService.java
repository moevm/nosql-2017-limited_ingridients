package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Ingredient;
import movies.spring.data.neo4j.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Transactional()
    public void  createNewIngredient(String typeLabel,String label,Double weight,String measure) {
        ingredientRepository.createNewIngredient(typeLabel,label,weight,measure);
    }

    @Transactional()
    public void  createNewReceptIngredient(String receptlabel,String label,Double weight,String measure) {
        ingredientRepository.createNewReceptIngredient(receptlabel,label,weight,measure);
    }

    public void deleteIngredient(String typeLabel,Long ingr_id){
        ingredientRepository.deleteIngredient(typeLabel,ingr_id);
    }


    public void deleteIngredientFromRecept(String receptLabel, Long ingr_id){
        ingredientRepository.deleteIngredientFromRecept(receptLabel,ingr_id);
    }

    @Transactional()
    public void addSomeWeight(String type_label, String ingr_label,Double weight){
        ingredientRepository.addSomeWeight(type_label,ingr_label,weight);
    }

    @Transactional(readOnly = true)
    public Collection<Ingredient> getAllfromType(Long id) {
        return ingredientRepository.getAllfromType(id);
    }

    @Transactional(readOnly = true)
    public Collection<Ingredient> getAllfromRecept(Long id) {
        return ingredientRepository.getAllfromRecept(id);
    }

    @Transactional(readOnly = true)
    public Collection<Ingredient> getAll(Long id) {
        return ingredientRepository.getAll(id);
    }

}
