package com.trekExpert.expertguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "ExpertGuide API", version = "1.0", description = "Expert Guide REST API"))
@SpringBootApplication
public class ExpertGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpertGuideApplication.class, args);
    }
}
