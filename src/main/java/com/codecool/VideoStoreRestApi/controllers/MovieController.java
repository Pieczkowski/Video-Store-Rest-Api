package com.codecool.VideoStoreRestApi.controllers;

import com.codecool.VideoStoreRestApi.model.Movie;
import com.codecool.VideoStoreRestApi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/store/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getAllMovies(){
        return this.movieService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postMovie(@RequestParam("title") String title,
                          @RequestParam("director") String director,
                          @RequestParam("year") Date year,
                          @RequestParam("length") int length
                          ){
        System.out.println("saved");
         movieService.createMovie(title, director, year, length);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void putMovie(@PathVariable("id") int id,
                         @RequestParam(value = "title", required = false) String title,
                         @RequestParam(value = "director", required = false) String director,
                         @RequestParam(value = "genre", required = false) String genre,
                         @RequestParam(value = "year", required = false) Date year,
                         @RequestParam(value = "length", required = false) int length){

        return movieService.updateMovie(id, title, director, genre, year, length);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable(value = "id") int id){
        return movieService.deleteMovie(id);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllMovies(){
        return movieService.deleteAllMovies();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable("id") int id){
        return movieService.getById(id);
    }
}
