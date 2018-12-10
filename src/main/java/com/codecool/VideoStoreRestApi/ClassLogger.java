package com.codecool.VideoStoreRestApi;

import com.codecool.VideoStoreRestApi.Exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassLogger {

    public static Logger videoStoreRestApiApplicationLogger = LogManager.getLogger(VideoStoreRestApiApplication.class);

    public static Logger directorNotFoundExceptionLogger = LogManager.getLogger(DirectorNotFoundException.class);
    public static Logger genreNotFoundExceptionLoggerLogger = LogManager.getLogger(GenreNotFoundException.class);
    public static Logger movieNotFoundExceptionLoggerLogger = LogManager.getLogger(MovieNotFoundException.class);

}
