package com.example.poke.pokeApi.services;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.repositories.PokemonApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokeApiService {

    @Autowired
    private PokemonApiRepository repository;
    //empty constructor
    public PokeApiService(){

    }

    //get the pokemons list
    public PokemonApiListResponse getPokemons(String limit, String offset){
        return repository.getAllPokemons(limit, offset);
    }

    
}
