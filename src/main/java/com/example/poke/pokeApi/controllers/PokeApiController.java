package com.example.poke.pokeApi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import com.example.poke.pokeApi.models.Pokemon;
import com.example.poke.pokeApi.models.PokemonListResponse;
import com.example.poke.pokeApi.services.PokeApiService;


@RestController
@RequestMapping("/api")
public class PokeApiController {

    @Autowired
    private PokeApiService service;
    
     //endpoint for get the pokemon list
    @GetMapping("/pokemons")
    public PokemonListResponse getPokemons(@RequestParam(required = false) String limit, @RequestParam(required = false) String offset){
        return service.getPokemons(limit, offset);
    }
    //endpoint for get the detail information about a pokemon
    @GetMapping("/pokemons/{name}")
    public Pokemon getInfoPokemon(@PathVariable String name){
        return service.getInfoPokemon(name);
    }
}
