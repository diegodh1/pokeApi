package com.example.poke.pokeApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//component to make request to external apis
@Component
public class RestTemplateClient {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
