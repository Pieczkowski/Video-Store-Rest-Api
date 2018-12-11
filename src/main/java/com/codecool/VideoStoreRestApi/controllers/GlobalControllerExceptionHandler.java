package com.codecool.VideoStoreRestApi.controllers;

import com.codecool.VideoStoreRestApi.Exceptions.DirectorNotFoundException;
import com.codecool.VideoStoreRestApi.Exceptions.GenreNotFoundException;
import com.codecool.VideoStoreRestApi.Exceptions.MovieNotFoundException;
import com.codecool.VideoStoreRestApi.services.statusInfo.InfoMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalControllerExceptionHandler {

    InfoMailService mailService;

    @Autowired
    GlobalControllerExceptionHandler(InfoMailService mailService){
        this.mailService = mailService;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler(value = {MovieNotFoundException.class, GenreNotFoundException.class, DirectorNotFoundException.class})
    public String internalServerErrorHandler(HttpServletRequest request, Exception ex){
        // log

        // send mail
        mailService.send("tirvwar@gmail.com", "Video-Store Internal Server Error 500", "Exception " + ex + "\nCaused by: method" + request.getMethod()
                + "\npath: "+ request.getRequestURI());
        return "internalError";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ModelAndView notFoundExceptionHandler(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        model.addObject("url", request.getRequestURL());
        model.setViewName("error");
        return model;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ModelAndView noParameterExceptionHandler(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        model.addObject("url", request.getRequestURL());
        model.setViewName("error");
        return model;
    }


}
