package com.example.poke.pokeApi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.services.PokeApiService;

@RestController
public class PokeApiController {

    @Autowired
    private PokeApiService service;
    
    @GetMapping("/pokemons")
    public PokemonApiListResponse getPokemons(@RequestParam(required = false) String limit, @RequestParam(required = false) String offset){
        return service.getPokemons(limit, offset);
    }
}
