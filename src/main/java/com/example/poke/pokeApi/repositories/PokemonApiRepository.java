package com.example.poke.pokeApi.repositories;

import com.example.poke.pokeApi.models.Exceptions.ApiNotFoundResponse;
import com.example.poke.pokeApi.models.Exceptions.ApiResponseError;
import com.example.poke.pokeApi.models.Exceptions.InternalResponseError;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonInfoApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
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
            //convert the request params to int
            int limitNumber = limit!= null?Integer.parseInt(limit):0;
            //the limit of elements should be less than 30 to better performance
            if(limitNumber > 30){
                throw new ApiResponseError("the limit of items should be less than 30 to better performance");
            }
            PokemonApiListResponse result = restTemplate.getForObject(url, PokemonApiListResponse.class);
            return result;
        }
        catch(ApiResponseError e){
            throw new ApiResponseError(e.toString());
        }
        catch(NumberFormatException e){
            throw new ApiResponseError("the request params should be integers");
        }
        catch(Exception e){
            throw new InternalResponseError(e.toString());
        }
    }

    //get the basic information from a pokemon
    public PokemonInfoApiResponse getInfoPokemon(String name){
        String url = baseUrl + String.format("/%s", name);
        try{
            PokemonInfoApiResponse result = restTemplate.getForObject(url, PokemonInfoApiResponse.class);
            return result;
        }
        catch(HttpClientErrorException e){
            throw new ApiNotFoundResponse(e.toString());
        }
        catch(Exception e){
            throw new InternalResponseError(e.toString());
        }

    }
    
}
