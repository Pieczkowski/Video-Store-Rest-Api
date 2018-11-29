package com.codecool.VideoStoreRestApi.repositories;

import com.codecool.VideoStoreRestApi.model.Director;
import com.codecool.VideoStoreRestApi.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface DirectorRepository extends CrudRepository<Director, Long> {
//    Collection<Director> findByFirst_nameAndLast_name(String firstName, String lastName);
    boolean existsDirectorByFirst_namAndLast_name(String firstName, String lastName);
    Director getDirectorByFirst_nameAndLast_name(String firstName, String lastName);
}
