package com.neo4j.example.springdataneo4jintroapp.controllers;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Movie;
import com.neo4j.example.springdataneo4jintroapp.repositories.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jennifer Reif
 * @author Vladimir Plizga
 */
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    @GetMapping("/{title}")
    public Movie getMovieByTitle(@PathVariable String title) {
        return movieRepository.getMovieByTitle(title);
    }

    @GetMapping("/search/{title}")
    public Iterable<Movie> findMovieByTitleLike(@PathVariable String title) {
        return movieRepository.findMovieByTitleLike(title);
    }

    @GetMapping("/search/by-title/{word}")
    public Iterable<Movie> findMovieByTitleContaining(@PathVariable String word) {
        return movieRepository.findMovieByTitleContaining(word);
    }

    @GetMapping("/search/by-description/{word}")
    public Iterable<Movie> findTop3ByDescriptionContaining(@PathVariable String word) {
        return movieRepository.findTop3ByDescriptionContaining(word);
    }
}
