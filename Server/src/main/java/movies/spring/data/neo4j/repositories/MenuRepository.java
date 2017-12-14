package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Menu;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "menu's", path = "menu's")
public interface  MenuRepository extends PagingAndSortingRepository<Menu, Long> {

    @Query("CREATE (userFirdg:Menu {userID:{userID}}) RETURN userFirdg")
    Menu createNewMenu(@Param("userID") String userID);


    @Query("MATCH (fr:Menu {userID: {userID}}) RETURN fr")
    Menu getMenuByName(@Param("userID") String userID);
}
