package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Dish_Type;
import movies.spring.data.neo4j.domain.Ingredient;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

import static movies.spring.data.neo4j.constants.EATRelations.MEAL_CONTAINTS;


public interface Dish_TypeRepository extends PagingAndSortingRepository<Dish_Type, Long> {

    @Query("MATCH (newIngr_Type:Meal)"+
            "WHERE ID(newIngr_Type)={id}"+
           "CREATE (ingr:Dish_Type {label:{label}})"+
           "CREATE (ingr)<-[:"+MEAL_CONTAINTS+"]-(newIngr_Type)")
    void createNewDish_Type(@Param("id") Long id, @Param("label") String label);

    @Query("MATCH (newIngr_Type:Meal)-[r:"+MEAL_CONTAINTS+"]->(m:Dish_Type) WHERE ID(newIngr_Type)={id} RETURN r,newIngr_Type,m")
    Collection<Dish_Type> getAll(@Param("id") Long id);
}