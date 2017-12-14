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
    public Menu  createNewMenu(String userID) {
        return menuRepository.createNewMenu(userID);
    }

    @Transactional(readOnly = true)
    public Menu getMenuByName(String userID) {
        return menuRepository.getMenuByName(userID);
    }
}
