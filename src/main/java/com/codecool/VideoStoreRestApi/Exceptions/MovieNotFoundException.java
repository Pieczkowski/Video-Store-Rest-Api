package com.codecool.VideoStoreRestApi.Exceptions;

public class MovieNotFoundException extends RuntimeException  {

    public MovieNotFoundException(String message) {
        super(message);
    }
}
