package com.codecool.VideoStoreRestApi.services;

import com.codecool.VideoStoreRestApi.VideoStoreRestApiApplication;
import com.codecool.VideoStoreRestApi.model.Director;
import com.codecool.VideoStoreRestApi.model.Movie;
import com.codecool.VideoStoreRestApi.repositories.DirectorRepository;
import com.codecool.VideoStoreRestApi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DirectorService {

    private DirectorRepository directorRepository;
    private MovieRepository movieRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
    }

    public Collection<Director> getAllDirectors() {
        return this.directorRepository.findAll();
    }

    public Director getDirectorById(Long id) {
        return this.directorRepository.findOne(id);
    }

    public void deleteDirectorById(Long idDirector) {
        this.directorRepository.delete(idDirector);
    }

    public void deleteAllDirectors() {
        this.directorRepository.deleteAll();
    }

    public void updateDirector(Long id, String first_name, String last_name) {
        Director director = getDirectorById(id);
        if(first_name != null){
            director.setFirstName(first_name);
        }
        if(last_name != null){
            director.setLastName(last_name);
        }
        this.directorRepository.save(director);
    }

    public void createDirector(String first_name, String last_name) {
        Director director = new Director();
        director.setFirstName(first_name);
        director.setLastName(last_name);

        this.directorRepository.save(director);
    }

    public void saveDirector(Director director){
    this.directorRepository.save(director);
    }


    public boolean isDirectorExist(String firstName, String lastName){
        return this.directorRepository.existsDirectorByFirstNameAndLastName(firstName, lastName);
    }

    public Director getDirector(String firstName, String lastName) {
        return this.directorRepository.getDirectorByFirstNameAndLastName(firstName, lastName);
    }

    public Collection<Movie> getDirectorMovies(Long idDirector){
        return this.movieRepository.findMovieByDirectorsIdDirector(idDirector);

    }

}
