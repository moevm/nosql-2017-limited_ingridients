package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Recept;
import movies.spring.data.neo4j.repositories.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ReceptService {


    @Autowired
    private ReceptRepository receptRepository;

    @Transactional()
    public void  createNewRecept(Long id,String label,Long time,String someSubs) {
        receptRepository.createNewRecept(id,label,time,someSubs);
    }

    @Transactional(readOnly = true)
    public Collection<Recept> getAll(Long id) {
        return receptRepository.getAll(id);
    }

    @Transactional(readOnly = true)
    public Recept getByID(@Param("id") Long id){
        return receptRepository.getByID(id);
    }

}
