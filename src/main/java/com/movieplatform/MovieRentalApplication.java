package com.movieplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // Important: This makes your Servlets work!
public class MovieRentalApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApplication.class, args);
    }
}
