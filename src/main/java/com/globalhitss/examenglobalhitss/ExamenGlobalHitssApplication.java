package com.globalhitss.examenglobalhitss;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info =
        @Info(
                title = "Examen Practico de GlobalHitss",
                description = """
                Este es un examen práctico donde se usa una arquitectura en capas y una persistencia con mongoDB para un diseño simple de una API RESTful
                """,
                version = "1.0"
        )
)
public class ExamenGlobalHitssApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenGlobalHitssApplication.class, args);
    }

}
