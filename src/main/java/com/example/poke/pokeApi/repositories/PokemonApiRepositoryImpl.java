package com.example.poke.pokeApi.repositories;

import java.util.ArrayList;

import com.example.poke.pokeApi.interfaces.PokemonApiRepositoryInterface;
import com.example.poke.pokeApi.models.Exceptions.ApiNotFoundResponse;
import com.example.poke.pokeApi.models.Exceptions.InternalResponseError;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiChainEvolution;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiCharacteristic;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiSpecie;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiStat;
import com.example.poke.pokeApi.models.ExternalApi.PokemonInfoApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonApiRepositoryImpl implements PokemonApiRepositoryInterface{
    //variables
    @Autowired
    private RestTemplate restTemplate;
    private static String baseUrl = "https://pokeapi.co/api/v2";

    //empty constructor
    public PokemonApiRepositoryImpl(){

    }
    //get all the pokemons
    public PokemonApiListResponse getAllPokemons(String limit, String offset){
        //setting external apis url
        String url = baseUrl+"/pokemon?";
        url = limit!= null? url + String.format("limit=%s", limit): url;
        url = offset!= null? limit!= null? url + String.format("&offset=%s", offset): url + String.format("offset=%s", offset): url;
        try{
            //call external api
            PokemonApiListResponse result = restTemplate.getForObject(url, PokemonApiListResponse.class);
            //set the url for previous and next results
            if(result.getNext()!=null){
                String[] next = result.getNext().split("\\?");
                result.setNext("https://pokemonservicev2.uc.r.appspot.com/api/pokemons?"+next[1]);
            }
            if(result.getPrevious()!=null){
                String[] prev = result.getPrevious().split("\\?");
                result.setPrevious("https://pokemonservicev2.uc.r.appspot.com/api/pokemons?"+prev[1]);
            }
            
            return result;
        }
        catch(HttpClientErrorException e){
            throw new ApiNotFoundResponse(e.toString());
        }
        catch(Exception e){
            throw new InternalResponseError(e.toString());
        }
    }

    //get the basic information from a pokemon
    public PokemonInfoApiResponse getPokemonInfo(String nameOrID){
        String url = baseUrl+"/pokemon/" + String.format("%s", nameOrID);
        try{
            //call external api
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

    //get the pokemon's evolutions
    public PokemonApiChainEvolution getEvolutions(String url){
        try{
            PokemonApiChainEvolution result = restTemplate.getForObject(url, PokemonApiChainEvolution.class);
            return result;
        }
        catch(HttpClientErrorException e){
            throw new ApiNotFoundResponse(e.toString());
        }
        catch(Exception e){
            throw new InternalResponseError(e.toString());
        }

    }

    //get the pokemon's characteristic ID that depends from HIV
    //time complexity O(n)

    //characteristics are divided in five groups, a group(0,1,2,3,4) refers to the remainder of divide 
    //the highest individual value (HIV) with 5 and each group have six subgroups
    //(HP, Attack, Defense, Special Attack, Special Defense, Speed) to know the characteristic ID of any pokemon
    //we need to make the operation 6 * (HIV % 5) + position of the maximum characteristic. for example:
    //pokemon1 has the next stats{HP=10, Attack=15, Defense=20, Special Attack=5, Special Defense=7, Speed=8}
    //so the characteristic ID is 6 * (20 % 5) + 3 = 3  and searching in the table of https://bulbapedia.bulbagarden.net/wiki/Characteristic
    //we can see that the value for the characteristicID = 3 is Sturdy body. we can see the the table like a matrix and each characteric Id
    //is a cell example the cell #1 = "Loves to eat", cell #2 = "Proud of its power", cell #8 = "Likes to thrash about"
    //to make sure that is of this way we can https://pokeapi.co/api/v2/characteristic/8/ test the hypothesis here
    public int getPokemonCharacteristicID(ArrayList<PokemonApiStat> stats){
        if(stats.isEmpty()){
            return -1;
        }
        else{
            int statPos = 1;
            int maxValue = stats.get(0).getBaseStat();
            for(int i = 1; i<stats.size(); i++){
                if(maxValue < stats.get(i).getBaseStat()){
                    statPos = i + 1;
                    maxValue = stats.get(i).getBaseStat();
                }
            }
            return 6 * (maxValue % 5) + statPos;
        }
    }

    //the method getPokemonCharacteristics allow us to know about the pokemon's description
    public PokemonApiCharacteristic getPokemonCharacteristics(int id){
        String url = baseUrl+"/characteristic/" + String.format("%d", id);
        try{
            PokemonApiCharacteristic result = restTemplate.getForObject(url, PokemonApiCharacteristic.class);
            return result;
        }
        catch(HttpClientErrorException e){
            throw new ApiNotFoundResponse(e.toString());
        }
        catch(Exception e){
            throw new InternalResponseError(e.toString());
        }

    }

    //we need this method because the pokemons evolutions depends of his species
    public PokemonApiSpecie getPokemonSpecie(String nameOrID){
        String url = baseUrl+"/pokemon-species/" + String.format("%s", nameOrID);
        try{
            PokemonApiSpecie result = restTemplate.getForObject(url, PokemonApiSpecie.class);
            return result;
        }
        catch(HttpClientErrorException e){
            return null;
        }
        catch(Exception e){
            throw new InternalResponseError(e.toString());
        }

    }

    
}
