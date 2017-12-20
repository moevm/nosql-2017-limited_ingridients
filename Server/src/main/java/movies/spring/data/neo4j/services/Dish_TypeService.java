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
    public void  createNewDish_Type(Long id,String label) {
        dish_typeRepository.createNewDish_Type(id,label);
    }

    @Transactional()
    public void deleteDish_Type(Long id, Long dish_id){
        dish_typeRepository.deleteDish_Type(id,dish_id);
    }

    @Transactional(readOnly = true)
    public Collection<Dish_Type> getAll(Long id) {
        return dish_typeRepository.getAll(id);
    }
}
