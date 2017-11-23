package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static movies.spring.data.neo4j.constants.EATRelations.FRIDGE_CONTAINTS;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Fridge {
    @GraphId
    private Long id;

    private String userID;

    @Relationship(type = FRIDGE_CONTAINTS, direction = Relationship.OUTGOING)
    private List<Ingr_Type> ingr_Types = new ArrayList<>();


    public Fridge() {
    }

    public Fridge(String userID) {
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

    public List<Ingr_Type> getIngr_Types() {
        return ingr_Types;
    }

    public void addIngr_Type(Ingr_Type ingr_type) {
        this.ingr_Types.add(ingr_type);
    }
}
