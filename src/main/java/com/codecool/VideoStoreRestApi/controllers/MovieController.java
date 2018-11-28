package com.codecool.VideoStoreRestApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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


}
