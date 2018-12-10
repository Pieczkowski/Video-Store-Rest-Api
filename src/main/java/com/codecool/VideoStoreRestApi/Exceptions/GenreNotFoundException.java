package com.codecool.VideoStoreRestApi.Exceptions;

import com.codecool.VideoStoreRestApi.ClassLogger;

public class GenreNotFoundException extends RuntimeException{

    public GenreNotFoundException(String message) {
        super(message);
        ClassLogger.genreNotFoundExceptionLoggerLogger.error("Genre log");

    }
}
