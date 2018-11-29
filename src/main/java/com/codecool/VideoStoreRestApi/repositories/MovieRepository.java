package com.codecool.VideoStoreRestApi.repositories;

import com.codecool.VideoStoreRestApi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    Collection<Movie> findAllByDirectors(Long id_director);
}
