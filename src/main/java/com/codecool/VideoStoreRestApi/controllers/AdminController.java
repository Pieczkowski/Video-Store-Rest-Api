package com.codecool.VideoStoreRestApi.controllers;

import com.codecool.VideoStoreRestApi.model.Movie;
import com.codecool.VideoStoreRestApi.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping("/admin/archived")
public class AdminController {

    private AdminService adminService;

    @Autowired
    AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public Collection<Movie> getArchivedMovies(){
        return adminService.getArchived();
    }
}
