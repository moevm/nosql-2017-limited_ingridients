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

    @Transactional()
    public void addSomeWeight(Long ingrID,Double weight){
        ingredientRepository.addSomeWeight(ingrID,weight);
    }

    @Transactional(readOnly = true)
    public Collection<Ingredient> getAll(Long id) {
        return ingredientRepository.getAll(id);
    }

    @Transactional(readOnly = true)
    public Collection<Ingredient> getAllRecept(Long id) {
        return ingredientRepository.getAllRecept(id);
    }


}
