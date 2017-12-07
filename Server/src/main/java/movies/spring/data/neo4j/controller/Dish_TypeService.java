package movies.spring.data.neo4j.services;


import movies.spring.data.neo4j.domain.Dish_Type;
import movies.spring.data.neo4j.repositories.Dish_TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class Dish_TypeService {

    @Autowired
    private Dish_TypeRepository dish_typeRepository;

    @Transactional()
    public void  createNewDish_Type(String mealLabel,String label) {
        dish_typeRepository.createNewDish_Type(mealLabel,label);
    }

    @Transactional(readOnly = true)
    public Collection<Dish_Type> getAll(Long id) {
        return dish_typeRepository.getAll(id);
    }
}
