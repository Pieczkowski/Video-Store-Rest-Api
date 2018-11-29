package com.codecool.VideoStoreRestApi.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private Long idDirector;

    private String firstName;
    private String lastName;


    @OneToMany(mappedBy = "directors", cascade = {CascadeType.ALL})
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_movie")
    @JsonIgnore
    private List<Movie> movies = new ArrayList<>();

    public Director(){}

    public Long getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Long idDirector) {
        this.idDirector = idDirector;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
