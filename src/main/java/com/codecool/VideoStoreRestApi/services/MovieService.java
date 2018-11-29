package com.codecool.VideoStoreRestApi.services;


import com.codecool.VideoStoreRestApi.model.Director;
import com.codecool.VideoStoreRestApi.model.Movie;
import com.codecool.VideoStoreRestApi.repositories.DirectorRepository;
import com.codecool.VideoStoreRestApi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Collection;

@Component
public class MovieService {

    private MovieRepository movieRepository;
    private DirectorService directorService

    @Autowired
    public MovieService(MovieRepository movieRepository, DirectorService directorService) {
        this.movieRepository = movieRepository;
        this.directorService = directorService;
    }

    public Collection<Movie> getAll() {
        return this.movieRepository.findAll();
    }

    public void createMovie(String title, String firstNameDirector, String lastNameDirector, Date year, int length) {
        Movie movie = new Movie();
        Director director;

        if(this.directorService.isDirectorExist(firstNameDirector, lastNameDirector)){
            director = this.directorService.getDirector(firstNameDirector, lastNameDirector);

        }
        else {
            director = new Director();
            director.setFirst_name(firstNameDirector);
            director.setLast_name(lastNameDirector);
            this.directorService.saveDirector(director);
        }

        movie.setTitle(title);
        movie.setDirectors(director);
        movie.setYear(year);
        movie.setLength(length);
       this.movieRepository.save(movie);
    }

    public void updateMovie(String title, String firstNameDirector, String lastNameDirector, Date year, int length){
        Director director = new Director();

    }
}
