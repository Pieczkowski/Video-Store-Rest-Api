package com.codecool.VideoStoreRestApi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private Long id_director;

    private String first_name;
    private String last_name;


    @OneToMany(mappedBy = "directors", cascade = {CascadeType.ALL})
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_movie")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Movie> movies = new ArrayList<>();

    public Director(){}



    public Long getId_director() {
        return id_director;
    }

    public void setId_director(Long id_director) {
        this.id_director = id_director;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
