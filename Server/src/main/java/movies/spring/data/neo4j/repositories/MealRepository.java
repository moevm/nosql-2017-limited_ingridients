package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Meal;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

import static movies.spring.data.neo4j.constants.EATRelations.MENU_CONTAINTS;

@RepositoryRestResource(collectionResourceRel = "meal's", path = "meal's")
public interface MealRepository extends PagingAndSortingRepository<Meal, Long> {

    @Query("MATCH (userFridge:Menu)"+
            "WHERE ID(userFridge)={id}" +
           "CREATE (newIngr_Type:Meal {label:{label}}) "+
           "CREATE (newIngr_Type)<-[:"+MENU_CONTAINTS+"]-(userFridge)")
    void createNewMeal(@Param("id") Long id, @Param("label") String label);

    @Query("MATCH (userFridge:Menu)-[:"+MENU_CONTAINTS+"]->(m:Meal) WHERE ID(userFridge)={id} RETURN m")
    Collection<Meal> getAll(@Param("id") Long id);

}