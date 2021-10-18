package com.example.library.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//This class is used for creating the documentation
//http://localhost:8080/swagger-ui/
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

// Documentation of API INFO. Follow the link - https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API",
                "Some custom description of API BookStore.",
                "API TOS",
                "Terms of service",
                new Contact("Letícia Neves", "www.example.com", "leticianeves.ar@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
