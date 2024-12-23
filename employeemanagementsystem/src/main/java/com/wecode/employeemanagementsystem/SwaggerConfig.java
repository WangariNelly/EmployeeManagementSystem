package com.wecode.employeemanagementsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    private static final String TITLE = "Employee Management System API";
    private static final String DESCRIPTION = "API documentation for managing employees in the Employee Manager system";
    private static final String VERSION = "1.0.0";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title(TITLE).description(DESCRIPTION).version(VERSION))
                .addServersItem(new Server().url("http://localhost:8080"));
    }
}