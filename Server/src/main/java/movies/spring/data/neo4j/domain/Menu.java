package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static movies.spring.data.neo4j.constants.EATRelations.FRIDGE_CONTAINTS;
import static movies.spring.data.neo4j.constants.EATRelations.MENU_CONTAINTS;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Menu {
    @GraphId
    private Long id;

    private String userID;

    @Relationship(type = MENU_CONTAINTS, direction = Relationship.OUTGOING)
    private List<Meal> meals = new ArrayList<>();

    public Menu() {
    }

    public Menu(String userID) {
        this.userID = userID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }
}
