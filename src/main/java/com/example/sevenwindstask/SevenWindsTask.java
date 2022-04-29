package com.example.sevenwindstask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "SevenWinds Test API", version = "1.0", description = "SevenWinds Test API"))
public class SevenWindsTask {

    public static void main(String[] args) {
        SpringApplication.run(SevenWindsTask.class, args);
    }
}