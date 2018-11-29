package com.codecool.VideoStoreRestApi.services;

import com.codecool.VideoStoreRestApi.Exceptions.GenreNotFoundException;
import com.codecool.VideoStoreRestApi.model.Genre;
import com.codecool.VideoStoreRestApi.model.Movie;
import com.codecool.VideoStoreRestApi.repositories.GenreRepository;
import com.codecool.VideoStoreRestApi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class GenreService {

    private GenreRepository genreRepository;
    private MovieRepository movieRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository, MovieRepository movieRepository){
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
    }

    public Collection<Genre> getAll() {
        Collection<Genre> genreList = this.genreRepository.findAll();
        if(genreList.isEmpty()) throw new GenreNotFoundException("no any genre was found");
        return genreRepository.findAll();
    }

    public Genre getById(Long id) {
        Genre genre = genreRepository.findOne(id);
        if(genre == null) throw new GenreNotFoundException("no any genre was found");
        return genre;
    }

    public void updateGenre(Long id, String name, String description, Long movieId) {
        Genre genre = getById(id);
        if (name != null){
            genre.setName(name);
        }
        if (description != null){
            genre.setDescription(description);
        }
        if (movieId != null){
            Movie movie = movieRepository.findOne(movieId);
            genre.addMovies(movie);
        }
        genreRepository.save(genre);
    }

    public void createGenre(String name, String description) {
        Genre genre = new Genre();
        genre.setName(name);
        genre.setDescription(description);
        genreRepository.save(genre);
    }

    public Collection<Movie> getGenreMovies(Long id) {
        Collection<Movie> moviesList = genreRepository.findOne(id).getMovies();
        if(moviesList.isEmpty()) throw new GenreNotFoundException("no any genre was found");
        return moviesList;
    }
}
