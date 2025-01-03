package com.rsfrancisco.mercadolivro.configs
/*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.Contact

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.rsfrancisco.mercadolivro.controllers"))
        .paths(PathSelectors.any())
        .build()

        .apiInfo(ApiInfoBuilder()
            .title("Mercado Livro API")
            .description("REST API do Mercado Livro")
            .version("1.0.0")
            .contact(Contact("Rafael Francisco", "https://github.com/broncasrafa", "broncasrafa@gmail.com"))
            .build()
        )
}
*/