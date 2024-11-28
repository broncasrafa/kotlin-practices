package com.rsfrancisco.mercadolivro.configs

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server as OpenApiServer

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun api(): OpenAPI = OpenAPI()
            .components(Components()
                            .addSecuritySchemes("basicScheme", SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
            .info(Info()
                    .title("Mercado Livro API")
                    .description("REST API do Mercado Livro")
                    .version("v1")
                    .contact(Contact()
                        .name("Rafael Francisco")
                        .email("broncasrafa@gmail.com")
                        .url("https://github.com/broncasrafa")))
            .servers(
                listOf(
                    OpenApiServer().url("http://localhost:8080").description("Desenvolvimento")
                )
            )
}