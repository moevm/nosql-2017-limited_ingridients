package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static movies.spring.data.neo4j.constants.EATRelations.RECEPT_CONTAINTS;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Recept {

    @GraphId
    private Long id;

    private String label;

    private Long time;

    private String someSubs;

    @Relationship(type = RECEPT_CONTAINTS, direction = Relationship.OUTGOING)
    private List<Ingredient> ingredients = new ArrayList<>();


    public Recept() {
    }

    public Recept(String label) {
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

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSomeSubs() {
        return someSubs;
    }

    public void setSomeSubs(String someSubs) {
        this.someSubs = someSubs;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
