package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Recept;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

import static movies.spring.data.neo4j.constants.EATRelations.DISH_TYPE_CONTAINTS;
import static movies.spring.data.neo4j.constants.EATRelations.RECEPT_CONTAINTS;

@RepositoryRestResource(collectionResourceRel = "recepts", path = "recepts")
public interface ReceptRepository extends PagingAndSortingRepository<Recept, Long> {

    @Query("MATCH (userFridge:Dish_Type) "+
            "WHERE ID(userFridge)={id} "+
            "MERGE (newIngr_Type:Recept {label:{label}, time:{time}, someSubs:{someSubs}})"+
            "CREATE (newIngr_Type)<-[:"+DISH_TYPE_CONTAINTS+"]-(userFridge)")
    void createNewRecept(@Param("id") Long id, @Param("label") String label, @Param("time") Long time, @Param("someSubs") String someSubs);

    @Query("MATCH (userFridge:Dish_Type)-[:"+DISH_TYPE_CONTAINTS+"]->(m:Recept) WHERE ID(userFridge)={id} RETURN m")
    Collection<Recept> getAll(@Param("id") Long id);

    @Query("MATCH (userFridge:Recept)-[r:"+RECEPT_CONTAINTS+"]->(m:Ingredient) WHERE ID(userFridge)={id} RETURN userFridge,r,m")
    Recept getByID(@Param("id") Long id);

    @Query("MATCH (userFridge:Dish_Type)" +
            "WHERE ID(userFridge)={id}" +
            "MATCH (recept:Recept)" +
            "WHERE ID(recept)={recept_id}" +
            "MATCH (recept)<-[r:"+DISH_TYPE_CONTAINTS+"]-(userFridge)" +
            "DELETE r,recept")
    void deleteRecept(@Param("id") Long id, @Param("recept_id") Long recept_id);

}
