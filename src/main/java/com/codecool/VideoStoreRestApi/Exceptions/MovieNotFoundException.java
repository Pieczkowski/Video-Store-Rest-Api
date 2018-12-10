package com.codecool.VideoStoreRestApi.Exceptions;

import com.codecool.VideoStoreRestApi.ClassLogger;

public class MovieNotFoundException extends RuntimeException  {

    public MovieNotFoundException(String message) {
        super(message);
        ClassLogger.movieNotFoundExceptionLoggerLogger.error("Movie log");

    }
}
