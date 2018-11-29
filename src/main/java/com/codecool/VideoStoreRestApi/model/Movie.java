package com.codecool.VideoStoreRestApi.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private long id_movie;
    private String title;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "movies_genres",
            joinColumns = { @JoinColumn(name = "id_movie") },
            inverseJoinColumns = { @JoinColumn(name = "id_genre") }
    )
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_genre")
    @JsonIgnoreProperties({"description", "id_genre", "movies"})
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="idDirector")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDirector")
    @JsonIgnoreProperties({"idDirector", "movies"})
    private Director directors;

    private Date year;
    private int length;

    public long getId_movie() {
        return id_movie;
    }

    public void setId_movie(long id_movie) {
        this.id_movie = id_movie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirectors() {
        return directors;
    }

    public void setDirectors(Director directors) {
        this.directors = directors;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }



}
