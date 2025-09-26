package com.trivia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TriviaWebAppBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(TriviaWebAppBackendApplication.class, args);
    }
}
