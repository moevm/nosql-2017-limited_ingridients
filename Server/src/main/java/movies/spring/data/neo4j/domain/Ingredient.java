package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import static movies.spring.data.neo4j.constants.EATRelations.TYPES_INGR_CONTAINTS;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Ingredient {

    @GraphId
    private Long id;

    private String label;

    private Double weight;

    private String measure;

    @Relationship(type = TYPES_INGR_CONTAINTS, direction = Relationship.INCOMING)
    private Ingr_Type type;

    public Ingredient() {
    }

    public Ingredient(String label, Double weight, String measure) {
        this.label = label;
        this.weight = weight;
        this.measure = measure;
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

    public Double getWeight() {
        return weight;
    }

    public String getMeasure() {
        return measure;
    }

    public Ingr_Type getType() {
        return type;
    }

    public void setType(Ingr_Type type) {
        this.type = type;
    }
}
