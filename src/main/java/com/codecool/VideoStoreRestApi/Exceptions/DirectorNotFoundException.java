package com.codecool.VideoStoreRestApi.Exceptions;

public class DirectorNotFoundException extends RuntimeException{

    public DirectorNotFoundException(String message) {
        super(message);
    }
}
