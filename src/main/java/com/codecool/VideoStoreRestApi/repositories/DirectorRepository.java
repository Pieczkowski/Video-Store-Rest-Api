package com.codecool.VideoStoreRestApi.repositories;

import com.codecool.VideoStoreRestApi.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    boolean existsDirectorByFirstNameAndLastName(String firstName, String lastName);
    Director getDirectorByFirstNameAndLastName(String firstName, String lastName);
}
