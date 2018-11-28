package com.codecool.VideoStoreRestApi.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="genres")
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_genre;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "genres")
    private Set<Movies> movies = new HashSet<>();

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }
}
