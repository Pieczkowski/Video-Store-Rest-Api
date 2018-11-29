package com.codecool.VideoStoreRestApi.services;

import com.codecool.VideoStoreRestApi.model.Director;
import com.codecool.VideoStoreRestApi.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DirectorService {

    private DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Collection<Director> getAllDirectors() {
        return this.directorRepository.findAll();
    }

    public Director getDirectorById(int id) {
        return this.directorRepository.findOne((long) id);
    }

    public void deleteDirectorById(int id_director) {
        this.directorRepository.delete((long) id_director);
    }

    public void deleteAllDirectors() {
        this.directorRepository.deleteAll();
    }

    public void updateDirector(int id, String first_name, String last_name) {
        Director director = getDirectorById(id);
        if(first_name != null){
            director.setFirst_name(first_name);
        }
        if(last_name != null){
            director.setLast_name(last_name);
        }
        this.directorRepository.save(director);
    }

    public void createDirector(String first_name, String last_name) {
        Director director = new Director();
        director.setFirst_name(first_name);
        director.setLast_name(last_name);

        this.directorRepository.save(director);
    }

//    public Collection<Movie> getDirectorMovies(int id){
//        return this.directorRepository.getMoviesByDirectorId(id);
//    }
}
