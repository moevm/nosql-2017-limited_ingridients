package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Ingredient;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

import static movies.spring.data.neo4j.constants.EATRelations.RECEPT_CONTAINTS;
import static movies.spring.data.neo4j.constants.EATRelations.TYPES_INGR_CONTAINTS;


public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long> {

    @Query("MATCH (newIngr_Type:Ingr_Type {label:{typeLabel}})"+
           "CREATE (ingr:Ingredient {label:{label}, weight:{weight}, measure:{measure}})"+
           "CREATE (ingr)<-[:"+TYPES_INGR_CONTAINTS+"]-(newIngr_Type)")
    void createNewIngredient(@Param("typeLabel") String typeLabel, @Param("label") String label, @Param("weight") Double weight, @Param("measure") String measure);

    @Query("MATCH (newIngr_Type:Recept {label:{receptLabel}})"+
            "CREATE (ingr:Ingredient {label:{label}, weight:{weight}, measure:{measure}})"+
            "CREATE (ingr)<-[:"+RECEPT_CONTAINTS+"]-(newIngr_Type)")
    void createNewReceptIngredient(@Param("receptLabel") String receptLabel, @Param("label") String label, @Param("weight") Double weight, @Param("measure") String measure);


    @Query("MERGE (ingr:Ingredient) "+
            "ON MATCH  SET ingr += { weight:{weight}+ingr.weight } "+
            "WHERE ID(ingr)={id}")
    void addSomeWeight(@Param("typeLabel") Long ingrID,@Param("weight") Double weight);


    @Query("MATCH (newIngr_Type:Ingr_Type)-[r:"+TYPES_INGR_CONTAINTS+"]->(m:Ingredient) WHERE ID(newIngr_Type)={id} RETURN r,newIngr_Type,m")
    Collection<Ingredient> getAll(@Param("id") Long id);

    @Query("MATCH (newIngr_Type:Recept)-[r:"+RECEPT_CONTAINTS+"]->(m:Ingredient) WHERE ID(newIngr_Type)={id} RETURN r,newIngr_Type,m")
    Collection<Ingredient> getAllRecept(@Param("id") Long id);
}