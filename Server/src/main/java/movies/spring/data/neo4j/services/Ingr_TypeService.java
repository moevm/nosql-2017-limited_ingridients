package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Ingr_Type;
import movies.spring.data.neo4j.repositories.Ingr_TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class Ingr_TypeService {

    @Autowired
    private Ingr_TypeRepository ingr_typeRepository;

    @Transactional()
    public void  createNewIngr_Type(String userID,String label) {
        ingr_typeRepository.createNewIngr_Type(userID,label);
    }

    @Transactional(readOnly = true)
    public Collection<Ingr_Type> getAll(Long id) {
        return ingr_typeRepository.getAll(id);
    }

    @Transactional()
    public void deleteIngr_type(Long fridegID, Long ingr_type_ID){
        ingr_typeRepository.deleteIngr_type(fridegID,ingr_type_ID);
    }
}
