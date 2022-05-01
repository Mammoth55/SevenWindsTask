package com.sigma.task;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "SIGMA Test API", version = "1.0", description = "SIGMA Test API"))
public class SigmaTask {

    public static void main(String[] args) {
        SpringApplication.run(SigmaTask.class, args);
    }
}