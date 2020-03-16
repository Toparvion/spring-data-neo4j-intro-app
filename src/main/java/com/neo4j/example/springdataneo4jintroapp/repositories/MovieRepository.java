package com.neo4j.example.springdataneo4jintroapp.repositories;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author Jennifer Reif
 * @author Vladimir Plizga
 */
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie getMovieByTitle(String title);

    /**
     * Searches for movies by given regexp, e.g. {@code .*Matrix}
     * @param title the regular expression to match
     * @return movies matched the query
     */
    Iterable<Movie> findMovieByTitleLike(String title);

    /**
     * Searches for movies whose title contains given word, e.g. {@code Matrix}
     * @param word a substring to search the title for
     * @return movies matched the query
     */
    Iterable<Movie> findMovieByTitleContaining(String word);

    Iterable<Movie> findTop3ByDescriptionContaining(String word);
}
