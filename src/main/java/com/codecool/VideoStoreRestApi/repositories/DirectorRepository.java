package com.codecool.VideoStoreRestApi.repositories;

import com.codecool.VideoStoreRestApi.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {

//    Collection<Movie> getMoviesByDirectorId(int id_director);
}
