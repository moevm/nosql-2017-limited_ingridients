package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Fridge;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "fridges", path = "fridges")
public interface  FridgeRepository extends PagingAndSortingRepository<Fridge, Long> {

    @Query("CREATE (userFirdg:Fridge {userID:{userID}}) RETURN userFirdg")
    Fridge createNewFridge(@Param("userID") String userID);


    @Query("MATCH (fr:Fridge {userID: {userID}}) RETURN fr")
    Fridge getFridgeByName(@Param("userID") String userID);
}
