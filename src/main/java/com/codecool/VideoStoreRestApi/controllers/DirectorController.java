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
    public void deleteDirectorById(@PathVariable("id") int id){
        directorService.deleteDirectorById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllDirectors(){
        directorService.deleteAllDirectors();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateDirectorById(@PathVariable("id") int id,
                                   @RequestParam("first_name") String first_name,
                                   @RequestParam("last_name") String last_name){
        directorService.updateDirector(id, first_name, last_name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertDirector(@RequestParam("first_name") String first_name,
                               @RequestParam("last_name") String last_name){
        //TODO
        directorService.insertDirectorToDb(director);
    }

    @RequestMapping(value = "/{id}/movies", method = RequestMethod.GET)
    public Collection<Movie> getDirectorMovies(@PathVariable("id") int id){
        return directorService.getDirectorMovies(id);
    }
}