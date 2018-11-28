package com.codecool.VideoStoreRestApi.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "directors")
public class Directors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_director;

    private String first_name;
    private String last_name;

    @OneToMany(mappedBy = "directors")
    private List<Movies> movies = new ArrayList<>();

    public Directors(){}



    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
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

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }
}
