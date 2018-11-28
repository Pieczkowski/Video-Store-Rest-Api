package com.codecool.VideoStoreRestApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


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

    @RequestMapping(method = RequestMethod.POST)
    public void postMovie(@RequestParam("title") String title,
                          @RequestParam("director") String director,
                          @RequestParam("year") Date year,
                          @RequestParam("length") int length
                          ){

        return movieService.createMovie(title, director, year, length);
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
