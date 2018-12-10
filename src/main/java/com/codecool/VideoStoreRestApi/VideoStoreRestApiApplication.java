package com.codecool.VideoStoreRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoStoreRestApiApplication {

	public static void main(String[] args) {

        ClassLogger.videoStoreRestApiApplicationLogger.info("Logger is configured correctly");
		SpringApplication.run(VideoStoreRestApiApplication.class, args);
	}
}
