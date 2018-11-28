package com.codecool.VideoStoreRestApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/store/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Movie> getAllMovies(){
        return movieService.getAll();
    }

    @RequestMapping(value = "?...", method = RequestMethod.POST)
    public void postMovie(){
        //TODO
        return movieService.createMovie();
    }

    @RequestMapping(value = "/{id}?...", method = RequestMethod.PUT)
    public void putMovie(@PathVariable("id") int id){
        //TODO
        return movieService.updateMovie(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable(value = "id") int id){
        return movieService.deleteMovie(id);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllMovies(){
        return movieService.deleteAllMovies();
    }

    @RequestMapping(value = "/store/movies/{id}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable("id") int id){
        return movieService.getById(id);
    }

}
