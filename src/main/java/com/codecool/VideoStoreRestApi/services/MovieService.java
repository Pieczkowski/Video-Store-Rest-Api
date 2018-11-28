package com.codecool.VideoStoreRestApi.services;


import com.codecool.VideoStoreRestApi.model.Director;
import com.codecool.VideoStoreRestApi.model.Movie;
import com.codecool.VideoStoreRestApi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Component
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return this.movieRepository.findAll();
    }

    public void createMovie(String title, String director, Date year, int length) {
        Movie movie = new Movie();
        Director director1 = new Director();
        director1.setFirst_name("Adam");
        director1.setLast_name("Mickiewicz");

        movie.setTitle(title);
        movie.setDirectors(director1);
        movie.setYear(year);
        movie.setLength(length);
       this.movieRepository.save(movie);
    }
}
