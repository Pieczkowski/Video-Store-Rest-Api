package com.codecool.VideoStoreRestApi.controllers;

import com.codecool.VideoStoreRestApi.services.statusInfo.InfoMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

    InfoMailService mailService;

    @Autowired
    CustomErrorController(InfoMailService mailService){
        this.mailService = mailService;
    }
    @RequestMapping(value = "/error")
    public String sendEmail(HttpServletRequest httpRequest){
        System.out.println("\n \n \n test");
        mailService.send("tirvwar@gmail.com","test subject", "This is a test m8.");
        return "error";
    }

private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
