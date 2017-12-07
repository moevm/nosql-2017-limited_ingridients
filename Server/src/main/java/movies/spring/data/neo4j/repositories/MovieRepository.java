package movies.spring.data.neo4j.repositories;

import java.util.Collection;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {


	Movie findByTitle(@Param("title") String title);

	Collection<Movie> findByTitleLike(@Param("title") String title);

	@Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
	Collection<Movie> graph(@Param("limit") int limit);

	@Query("MATCH (tom:Person {name: {name}})-[r:ACTED_IN]->(tomHanksMovies) RETURN tom,r,tomHanksMovies")
	Collection<Movie> tomHanks(@Param("name") String name);


}

