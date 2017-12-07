package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Menu;
import movies.spring.data.neo4j.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Transactional()
    public void  createNewMenu(String userID) {
        menuRepository.createNewMenu(userID);
    }

    @Transactional(readOnly = true)
    public Menu requestMenu(String userID) {
        return menuRepository.requestMenu(userID);
    }
}
