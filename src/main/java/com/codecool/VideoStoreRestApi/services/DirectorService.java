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

    public Director getDirectorById(Long id) {
        return this.directorRepository.findOne(id);
    }

    public void deleteDirectorById(Long id_director) {
        this.directorRepository.delete(id_director);
    }

    public void deleteAllDirectors() {
        this.directorRepository.deleteAll();
    }

    public void updateDirector(Long id, String first_name, String last_name) {
        Director director = getDirectorById(id);
        if(first_name != null){
            director.setFirstName(first_name);
        }
        if(last_name != null){
            director.setLast_name(last_name);
        }
        this.directorRepository.save(director);
    }

    public void createDirector(String first_name, String last_name) {
        Director director = new Director();
        director.setFirstName(first_name);
        director.setLast_name(last_name);

        this.directorRepository.save(director);
    }

//    public Collection<Movie> getDirectorMovies(int id){
//        return this.directorRepository.getMoviesByDirectorId(id);
//    }

    public void saveDirector(Director director){
    this.directorRepository.save(director);
    }


    public boolean isDirectorExist(String firstName, String lastName){
//        Director director = this.directorRepository.getByFirst_nameAndLast_name(firstName, lastName);
//        if(director != null){
//            return true;
//        }
//        return false;
        return this.directorRepository.existsDirectorByFirstNameAndLastName(firstName, lastName);
    }

    public Director getDirector(String firstName, String lastName) {
        return this.directorRepository.getDirectorByFirstNameAndLastName(firstName, lastName);
    }
}
