package com.codecool.VideoStoreRestApi.repositories;

import com.codecool.VideoStoreRestApi.model.Director;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
//    Collection<Director> findByFirst_nameAndLast_name(String firstName, String lastName);
    boolean existsDirectorByFirst_namAndLast_name(String firstName, String lastName);
    Director getDirectorByFirst_nameAndLast_name(String firstName, String lastName);
}
