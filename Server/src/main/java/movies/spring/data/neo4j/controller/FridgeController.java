package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Fridge;
import movies.spring.data.neo4j.services.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/fridge")
public class FridgeController {

    final FridgeService fridgeService;

    @Autowired
    public FridgeController(FridgeService fridgeService) {
        this.fridgeService = fridgeService;
    }

    @RequestMapping("/new")
    public Fridge newFridge(@RequestParam(value = "userID") String userID) {
        return fridgeService.createNewFridge(userID);
    }

    @RequestMapping("/getFridgeByName")
    public Fridge getFridgeByName(@RequestParam(value = "userID") String userID) {
        return fridgeService.getFridgeByName(userID);
    }


}
