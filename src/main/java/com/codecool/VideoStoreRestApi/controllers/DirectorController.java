package com.codecool.VideoStoreRestApi.controllers;

import com.codecool.VideoStoreRestApi.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/store/directors")
public class DirectorController {

    private DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Director> getAllDirectors(){
        return directorService.getAllDirectors();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Director getDirector(@PathVariable("id") int id){
        return directorService.getDirectorById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSDirectorById(@PathVariable("id") int id){
        directorService.removeDirectorById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateDirectorById(@RequestBody Director director){
        //TODO
        directorService.updateDirector(director);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void insertDirector(@RequestBody Director director){
        //TODO
        directorService.insertDirectorToDb(director);
    }

    @RequestMapping(value = "/{id}/movies", method = RequestMethod.POST)
    public void getDirectorMovies(@RequestBody Director director){
        //TODO
    }
}
