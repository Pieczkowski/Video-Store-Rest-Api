package com.codecool.VideoStoreRestApi.services;

import com.codecool.VideoStoreRestApi.model.Movie;
import com.codecool.VideoStoreRestApi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AdminService {
    private MovieRepository movieRepository;

    @Autowired
    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> getArchived() {
        return this.movieRepository.findMovieByArchivedIsTrue();
    }
}
