package com.codecool.VideoStoreRestApi.Exceptions;

import com.codecool.VideoStoreRestApi.ClassLogger;

public class DirectorNotFoundException extends RuntimeException{

    public DirectorNotFoundException(String message) {
        super(message);
        ClassLogger.directorNotFoundExceptionLogger.error("Director log");

    }
}
