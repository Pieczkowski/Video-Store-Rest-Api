package com.codecool.VideoStoreRestApi.repositories;

import com.codecool.VideoStoreRestApi.Model.Director;
import com.codecool.VideoStoreRestApi.Model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {

//    Collection<Movie> getMoviesByDirectorId(int id_director);
}
