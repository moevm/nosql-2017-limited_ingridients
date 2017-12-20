package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static movies.spring.data.neo4j.constants.EATRelations.MEAL_CONTAINTS;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Meal {
    @GraphId
    private Long id;

    private String label;

    @Relationship(type = MEAL_CONTAINTS, direction = Relationship.OUTGOING)
    private List<Dish_Type> dish_types = new ArrayList<>();


    public Meal() {
    }

    public Meal(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public List<Dish_Type> getDish_types() {
        return dish_types;
    }

    public void addDish_type(Dish_Type dish_type){
        this.dish_types.add(dish_type);
    }
}
