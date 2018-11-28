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



}
