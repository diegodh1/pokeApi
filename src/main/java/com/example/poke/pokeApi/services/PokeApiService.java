package com.example.poke.pokeApi.services;
import java.util.ArrayList;

import com.example.poke.pokeApi.models.Pokemon;
import com.example.poke.pokeApi.models.PokemonListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiChainEvolution;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiCharacteristic;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiSpecie;
import com.example.poke.pokeApi.models.ExternalApi.PokemonInfoApiResponse;
import com.example.poke.pokeApi.repositories.PokemonApiRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class PokeApiService{

    @Autowired
    private PokemonApiRepositoryImpl repository;
    //empty constructor
    public PokeApiService(){

    }

    //get the pokemons list
    @Cacheable("pokemons")
    public PokemonListResponse getPokemons(String limit, String offset){
        //call the pokemons list from the external api
        PokemonApiListResponse result =  repository.getAllPokemons(limit, offset);
        //prepare the final response
        PokemonListResponse pokemonList = new PokemonListResponse();
        if(result != null){
            //the total number of elements
            pokemonList.setCount(result.getCount());
            //the next elements of the list
            if(result.getNext()!=null)pokemonList.setNext(result.getNext());
            //the previous elements of the list
            if(result.getPrevious()!=null)pokemonList.setPrevious(result.getPrevious());
            ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
            //for each pokemon from the external api list get the basic information of each one
            for(int i = 0; i <result.getResults().size(); i++){
                //call the external api to get the pokemon's basic information
                PokemonInfoApiResponse pokemonTemp = repository.getPokemonInfo(result.getResults().get(i).getName());
                if(pokemonTemp != null){
                    //if pokemon basic information is not null set the attributes of the pokemon
                    Pokemon temp = new Pokemon();
                    temp.setPhoto(pokemonTemp.getSprites().getOther().getDreamWorld().getFrontDefault());
                    temp.setHeight(pokemonTemp.getHeight());
                    temp.setWeight(pokemonTemp.getWeight());
                    temp.setName(pokemonTemp.getName());
                    temp.setAbilities(pokemonTemp.getAbilities());
                    temp.setTypes(pokemonTemp.getTypes());
                    //add to the final list of pokemons response
                    pokemons.add(temp);
                }
            }
            pokemonList.setResults(pokemons);
        }
        //return the pokemon list
        return pokemonList;
    }

    //get the information detail from a pokemon
    @Cacheable("pokemon")
    public Pokemon getInfoPokemon(String name){
        Pokemon pokemon = new Pokemon();
        //search the pokemon in the external api rest
        PokemonInfoApiResponse result =  repository.getPokemonInfo(name);
        if(result != null){
            //setting the attributes
            pokemon.setPhoto(result.getSprites().getOther().getDreamWorld().getFrontDefault());
            pokemon.setHeight(result.getHeight());
            pokemon.setWeight(result.getWeight());
            pokemon.setName(result.getName());
            pokemon.setStats(result.getStats());
            pokemon.setAbilities(result.getAbilities());
            pokemon.setTypes(result.getTypes());
            PokemonApiSpecie specie = repository.getPokemonSpecie(name);
            PokemonApiChainEvolution chain = repository.getEvolutions(specie.getEvolutionChain().getUrl());
            int characteristicID = repository.getPokemonCharacteristicID(pokemon.getStats());
            //get the pokemon's description
            if(characteristicID > 0){
                PokemonApiCharacteristic characteristic = repository.getPokemonCharacteristics(characteristicID);
                if(characteristic != null){
                    pokemon.setDescriptions(characteristic.getDescriptions());
                }
            }
            pokemon.setEvolutions(chain);
        }
        //only returns if the pokemon exists if not we throw an exception 404 not found
        return pokemon;
    }

    
}
