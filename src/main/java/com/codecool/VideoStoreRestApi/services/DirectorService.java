package com.codecool.VideoStoreRestApi.services;

import com.codecool.VideoStoreRestApi.Exceptions.DirectorNotFoundException;
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
        Collection<Director> directorsList = this.directorRepository.findAll();
        if(directorsList.isEmpty()) throw new DirectorNotFoundException("no any director was found");
        return directorsList;
    }

    public Director getDirectorById(Long id) {
        Director director = this.directorRepository.findOne(id);
        if(director == null) throw new DirectorNotFoundException("director was found");
        return director;
    }

    public void deleteDirectorById(Long idDirector) {
        Director director = getDirectorById(idDirector);
        if(director == null) throw new DirectorNotFoundException("director was found");
        this.directorRepository.delete(idDirector);
    }

    public void deleteAllDirectors() {
        Collection<Director> directorsList = this.directorRepository.findAll();
        if(directorsList.isEmpty()) throw new DirectorNotFoundException("no any director was found");
        this.directorRepository.deleteAll();
    }

    public void updateDirector(Long id, String first_name, String last_name) {
        Director director = getDirectorById(id);
        if(director == null) throw new DirectorNotFoundException("director was found");
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
        Director director = this.directorRepository.getDirectorByFirstNameAndLastName(firstName, lastName);
        if(director == null) throw new DirectorNotFoundException("director was found");
        return director;
    }

    public Collection<Movie> getDirectorMovies(Long idDirector){
        Collection<Movie> moviesList = this.movieRepository.findMovieByDirectorsIdDirector(idDirector);
        if(moviesList.isEmpty()) throw new DirectorNotFoundException("no any director was found");
        return moviesList;

    }

}
