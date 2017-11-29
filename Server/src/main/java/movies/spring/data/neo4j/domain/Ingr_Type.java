package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static movies.spring.data.neo4j.constants.EATRelations.TYPES_INGR_CONTAINTS;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Ingr_Type {
    @GraphId
    private Long id;

    private String label;

    @Relationship(type = TYPES_INGR_CONTAINTS, direction = Relationship.OUTGOING)
    private List<Ingredient> ingrs = new ArrayList<>();


    public Ingr_Type() {
    }

    public Ingr_Type(String label) {
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

    public List<Ingredient> getIngrs() {
        return ingrs;
    }

    public void addIngridient(Ingredient ingredient){
        this.ingrs.add(ingredient);
    }
}
