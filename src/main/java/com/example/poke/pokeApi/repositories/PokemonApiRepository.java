package com.example.poke.pokeApi.repositories;

import com.example.poke.pokeApi.models.Exceptions.ApiResponseError;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonApiRepository {
    //attributes
    @Autowired
    private RestTemplate restTemplate;
    private static String baseUrl = "https://pokeapi.co/api/v2/pokemon";

    //empty constructor
    public PokemonApiRepository(){

    }

    //get all the pokemons
    public PokemonApiListResponse getAllPokemons(String limit, String offset){
        //setting external apis url
        String url = baseUrl;
        url = limit!= null? url + String.format("?limit=%s", limit): url;
        url = offset!= null? limit!= null? url + String.format("&offset=%s", offset): url + String.format("?offset=%s", offset): url;
        //call external api
        try{
            PokemonApiListResponse result = restTemplate.getForObject(url, PokemonApiListResponse.class);
            return result;
        }
        catch(ApiResponseError e){
            throw new ApiResponseError(e.toString());
        }
    }
    
}
