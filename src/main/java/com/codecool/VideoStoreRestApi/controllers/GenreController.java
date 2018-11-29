package com.codecool.VideoStoreRestApi.controllers;


import com.codecool.VideoStoreRestApi.Model.Genre;
import com.codecool.VideoStoreRestApi.Model.Movie;
import com.codecool.VideoStoreRestApi.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/store/genre")
public class GenreController {

    private GenreService genreService;

    @Autowired
    GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Genre> getAllGenres(){
        return genreService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Genre getGenre(@PathVariable("id") Long id){
        return genreService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void putGenre(@PathVariable("id") Long id,
                         @RequestParam(value = "title", required = false) String title,
                         @RequestParam(value = "desc", required = false) String description,
                         @RequestParam(value = "movieId", required = false) Long movieId){

        genreService.updateGenre(id, title, description, movieId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postGenre(@RequestParam(value = "name") String title,
                          @RequestParam(value = "desc") String description){

        genreService.createGenre(title, description);
    }

    @RequestMapping(value = "/{id}/movies", method = RequestMethod.GET)
    public Collection<Movie> getGenreMovies(@PathVariable("id") Long id){
        return genreService.getGenreMovies(id);
    }

}
