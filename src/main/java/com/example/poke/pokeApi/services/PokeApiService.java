package com.example.poke.pokeApi.services;
import java.util.ArrayList;

import com.example.poke.pokeApi.models.Pokemon;
import com.example.poke.pokeApi.models.PokemonListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonInfoApiResponse;
import com.example.poke.pokeApi.repositories.PokemonApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class PokeApiService {

    @Autowired
    private PokemonApiRepository repository;
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
            //set the final response attributes
            pokemonList.setCount(result.getCount());
            pokemonList.setNext(result.getNext());
            pokemonList.setPrevious(result.getPrevious());
            ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
            //for each pokemon from the external api list get the basic information of each one
            for(int i = 0; i <result.getResults().size(); i++){
                //call the external api to get the pokemon's basic information
                PokemonInfoApiResponse pokemonTemp = repository.getInfoPokemon(result.getResults().get(i).getName());
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

    @Cacheable("pokemon")
    //get the basic informacion from a pokemon
    public PokemonInfoApiResponse getInfoPokemon(String name){
        return repository.getInfoPokemon(name);
    }

    
}
