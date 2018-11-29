package com.codecool.VideoStoreRestApi.controllers;

import com.codecool.VideoStoreRestApi.model.Movie;
import com.codecool.VideoStoreRestApi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collection;


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
        return this.movieService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postMovie(@RequestParam("title") String title,
                          @RequestParam("firstNameDirector") String firstNameDirector,
                          @RequestParam("lastNameDirector") String lastNameDirector,
                          @RequestParam("year") Date year,
                          @RequestParam("length") int length
                          ){
        this.movieService.createMovie(title, firstNameDirector, lastNameDirector, year, length);
//        http://localhost:8080/store/movies?title=dupa&firstNameDirector=dupaName&lastNameDirector=dupaLastName2&year=2012-01-24&length=32
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void putMovie(@PathVariable("id") Long id,
                         @RequestParam(value = "title", required = false) String title,
                         @RequestParam(value = "idDirector", required = false) Integer idDirector,
                         @RequestParam(value = "year", required = false) Date year,
                         @RequestParam(value = "length", required = false) Integer length){

        this.movieService.updateMovie(id, title, idDirector, year, length);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable(value = "id") Long id){
        movieService.deleteMovie(id);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllMovies(){
        movieService.deleteAllMovies();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable("id") Long id){
        return movieService.getById(id);
    }
}
