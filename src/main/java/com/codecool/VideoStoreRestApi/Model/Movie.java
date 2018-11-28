package com.codecool.VideoStoreRestApi.Model;

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
    private int id_movie;
    private String title;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "movies_genres",
            joinColumns = { @JoinColumn(name = "id_movie") },
            inverseJoinColumns = { @JoinColumn(name = "id_genre") }
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="id_director")
    private Director directors;

    private Date year;
    private int length;

    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
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