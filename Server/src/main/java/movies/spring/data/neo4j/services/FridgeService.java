package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Fridge;
import movies.spring.data.neo4j.repositories.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FridgeService {

    @Autowired
    private FridgeRepository fridgeRepository;

    @Transactional()
    public void  createNewFridge(String userID) {
        fridgeRepository.createNewFridge(userID);
    }

    @Transactional(readOnly = true)
    public Fridge requestFridge(String userID) {
        return fridgeRepository.requestFridge(userID);
    }
}
