package com.codecool.VideoStoreRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class VideoStoreRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoStoreRestApiApplication.class, args);
	}
}
