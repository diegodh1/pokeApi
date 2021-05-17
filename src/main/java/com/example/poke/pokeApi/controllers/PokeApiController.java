package com.example.poke.pokeApi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.poke.pokeApi.models.PokemonListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonInfoApiResponse;
import com.example.poke.pokeApi.services.PokeApiService;

@RestController
public class PokeApiController {

    @Autowired
    private PokeApiService service;
    
    @GetMapping("/pokemons")
    public PokemonListResponse getPokemons(@RequestParam(required = false) String limit, @RequestParam(required = false) String offset){
        return service.getPokemons(limit, offset);
    }

    @GetMapping("/pokemons/{name}")
    public PokemonInfoApiResponse getInfoPokemon(@PathVariable String name){
        return service.getInfoPokemon(name);
    }
}
