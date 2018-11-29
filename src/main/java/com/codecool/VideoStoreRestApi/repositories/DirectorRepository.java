package com.codecool.VideoStoreRestApi.repositories;

import com.codecool.VideoStoreRestApi.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    @Query("SELECT first_name, last_name FROM Director WHERE first_name = firstName AND last_name = lastName")
    Director getByFirst_nameAndLast_name(@Param("firstName") String firstName, @Param("lastName")String lastName);
}
