package com.codecool.VideoStoreRestApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Genre getGenre(@PathVariable("id") int id){
        return genreService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void putGenre(@PathVariable("id") int id,
                         @RequestParam(value = "title", required = false) String title,
                         @RequestParam(value = "desc", required = false) String description){

        return genreService.updateGenre(id, title, description);
    }



}
