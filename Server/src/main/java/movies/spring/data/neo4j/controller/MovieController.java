package movies.spring.data.neo4j.controller;

import java.util.Collection;
import java.util.Map;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark Angrish
 */
@RestController("/")
public class MovieController {

	final MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping("/graph")
	public Collection<Movie> graph(@RequestParam(value = "limit",required = false) Integer limit) {
		return movieService.graph(limit == null ? 100 : limit);
	}

	@RequestMapping("/tom")
	public Collection<Movie> graph(@RequestParam(value = "name",required = false) String name) {
		return movieService.tomHanks(name == null ? "Tom Hanks" : name);
	}
}
