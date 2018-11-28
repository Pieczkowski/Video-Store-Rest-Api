package com.codecool.VideoStoreRestApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @RequestMapping(value = "/store/movies", method = RequestMethod.GET)
    public Collection<Movie> getAllMovies(){
        return movieService.getAll();
    }

    @RequestMapping(value = "/store/movies?...", method = RequestMethod.POST)
    public void postMovie(){
        //TODO
        return moviesService.createMovie();
    }

    @RequestMapping(value = "/store/movies/{id}?...", method = RequestMethod.PUT)
    public void putMovie(@PathVariable("id") int id){
        //TODO
        return moviesService.updateMovie(id);
    }

    @RequestMapping(value = "/store/movies/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable(value = "id") int id){
        return moviesService.deleteMovie(id);
    }
    @RequestMapping(value = "/store/movies", method = RequestMethod.DELETE)
    public void deleteAllMovies(){
        return moviesService.deleteAllMovies(id);
    }

    @RequestMapping(value = "/store/movies/{id}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable("id") int id){
        return moviesService.getById(id);
    }

}
