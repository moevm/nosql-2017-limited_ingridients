package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Ingr_Type;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

import static movies.spring.data.neo4j.constants.EATRelations.FRIDGE_CONTAINTS;

@RepositoryRestResource(collectionResourceRel = "ingr_types", path = "ingr_types")
public interface Ingr_TypeRepository extends PagingAndSortingRepository<Ingr_Type, Long> {

    @Query("MATCH (userFridge:Fridge {userID:{userID}})"+
           "MERGE (newIngr_Type:Ingr_Type {label:{label}})"+
           "CREATE (newIngr_Type)<-[:"+FRIDGE_CONTAINTS+"]-(userFridge)")
    void createNewIngr_Type(@Param("userID") String userID,@Param("label") String label);

    @Query("MATCH (userFridge:Fridge)-[:"+FRIDGE_CONTAINTS+"]->(m:Ingr_Type) WHERE ID(userFridge)={id} RETURN m")
    Collection<Ingr_Type> getAll(@Param("id") Long id);

    @Query("MATCH (userFridge:Fridge)"+
            "WHERE ID(userFridge)={fridegID}" +
            "MATCH (ingr_type:Ingr_Type)"+
            "WHERE ID(ingr_type)={ingr_type_ID}"+
            "MATCH (ingr_type)<-[r:"+FRIDGE_CONTAINTS+"]-(userFridge)"+
            "DELETE r,ingr_type")
    void deleteIngr_type(@Param("userID") Long fridegID,@Param("ingr_type_ID") Long ingr_type_ID);

}