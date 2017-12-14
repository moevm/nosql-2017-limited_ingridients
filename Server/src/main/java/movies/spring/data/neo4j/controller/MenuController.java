package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Menu;
import movies.spring.data.neo4j.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/menu")
public class MenuController {

    final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping("/new")
    public Menu newMenu(@RequestParam(value = "userID") String userID) {
        return menuService.createNewMenu(userID);
    }

    @RequestMapping("/getMenuByName")
    public Menu getMenuByName(@RequestParam(value = "userID") String userID) {
        return menuService.getMenuByName(userID);
    }


}
