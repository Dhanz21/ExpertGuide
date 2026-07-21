package com.trekExpert.expertguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpertGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpertGuideApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ExpertGuide API")
                        .version("1.0.0")
                        .description("Expert Guide REST API with Swagger Documentation"));
    }
}
