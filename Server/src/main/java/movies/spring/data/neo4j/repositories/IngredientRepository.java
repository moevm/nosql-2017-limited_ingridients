package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Ingredient;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

import static movies.spring.data.neo4j.constants.EATRelations.FRIDGE_CONTAINTS;
import static movies.spring.data.neo4j.constants.EATRelations.RECEPT_CONTAINTS;
import static movies.spring.data.neo4j.constants.EATRelations.TYPES_INGR_CONTAINTS;


public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long> {

    @Query("MATCH (newIngr_Type:Ingr_Type {label:{typeLabel}})"+
           "CREATE (ingr:Ingredient {label:{label}, weight:{weight}, measure:{measure}})"+
           "CREATE (ingr)<-[:"+TYPES_INGR_CONTAINTS+"]-(newIngr_Type)")
    void createNewIngredient(@Param("typeLabel") String typeLabel, @Param("label") String label, @Param("weight") Double weight, @Param("measure") String measure);

    @Query("MATCH (newIngr_Type:Ingr_Type {label:{typeLabel}})"+
            "MATCH (ingr:Ingredient)"+
            "WHERE ID(ingr)={ingr_id}"+
            "MATCH (ingr)<-[r:"+TYPES_INGR_CONTAINTS+"]-(newIngr_Type)"+
            "DELETE r,ingr")
    void deleteIngredient(@Param("typeLabel") String typeLabel, @Param("ingr_id") Long ingr_id);

    @Query("MATCH (newIngr_Type:Recept {label:{receptLabel}})"+
            "MATCH (ingr:Ingredient)"+
            "WHERE ID(ingr)={ingr_id}"+
            "MATCH (ingr)<-[r:"+RECEPT_CONTAINTS+"]-(newIngr_Type)"+
            "DELETE r,ingr")
    void deleteIngredientFromRecept(@Param("receptLabel") String receptLabel, @Param("ingr_id") Long ingr_id);


    @Query("MATCH (newIngr_Type:Recept {label:{receptLabel}})"+
            "CREATE (ingr:Ingredient {label:{label}, weight:{weight}, measure:{measure}})"+
            "CREATE (ingr)<-[:"+RECEPT_CONTAINTS+"]-(newIngr_Type)")
    void createNewReceptIngredient(@Param("receptLabel") String receptLabel, @Param("label") String label, @Param("weight") Double weight, @Param("measure") String measure);


    @Query("MERGE (newIngr_Type:Ingr_Type {label: {type_label}})-[r:"+TYPES_INGR_CONTAINTS+"]->(ingr:Ingredient {label: {ingr_label}}) "+
            "ON MATCH  SET ingr += { weight:{weight}+ingr.weight } ")
    void addSomeWeight(@Param("type_label") String type_label, @Param("ingr_label") String ingr_label,@Param("weight") Double weight);

    @Query("MATCH (newIngr_Type:Ingr_Type)-[r:"+TYPES_INGR_CONTAINTS+"]->(m:Ingredient) WHERE ID(newIngr_Type)={id} RETURN r,newIngr_Type,m")
    Collection<Ingredient> getAllfromType(@Param("id") Long id);

    @Query("MATCH (userFridge:Fridge)-[:"+FRIDGE_CONTAINTS+"]->(newIngr_Type:Ingr_Type)-[r:"+TYPES_INGR_CONTAINTS+"]->(m:Ingredient) WHERE ID(userFridge)={id} RETURN r,newIngr_Type,m")
    Collection<Ingredient> getAll(@Param("id") Long id);

    @Query("MATCH (newIngr_Type:Recept)-[r:"+RECEPT_CONTAINTS+"]->(m:Ingredient) WHERE ID(newIngr_Type)={id} RETURN r,newIngr_Type,m")
    Collection<Ingredient> getAllfromRecept(@Param("id") Long id);

//    @Query("MATCH (userFridge:Recept)-[r:"+RECEPT_CONTAINTS+"]->(m:Ingredient) WHERE ID(userFridge)={id} RETURN userFridge,r,m")
//    Ingredient getByLabel(@Param("label") String label);
}