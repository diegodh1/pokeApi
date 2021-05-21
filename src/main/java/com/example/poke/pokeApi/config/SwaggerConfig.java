package com.example.poke.pokeApi.config;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//this configuration allow us to create swagger documentation and of this way create all the information about this API Rest automatically
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final springfox.documentation.service.Contact DEFAULT_CONTACT = new springfox.documentation.service.Contact("Diego Díaz Hernández", "https://github.com/diegodh1", "diego.alexander.diaz@correounivalle.edu.co");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
        "PokeApi Documentation",
        "this service allow you to consume the external api https://pokeapi.co/ to get the basic information about a pokemon of a simplest way. Because in the external api to get the\n"+
        "different features about a pokemon you need to consume many endpoints to reach the desired information",
        "1.0", "Apache 2.0", DEFAULT_CONTACT,"LICENSE-2.0", "https://www.apache.org/licenses/LICENSE-2.0.html", Collections.emptyList());
    
    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(DEFAULT_API_INFO)
        .useDefaultResponseMessages(false);
    }
    
}
