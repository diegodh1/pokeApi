package com.example.poke.pokeApi.interfaces;

import java.util.ArrayList;

import com.example.poke.pokeApi.models.ExternalApi.PokemonApiChainEvolution;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiCharacteristic;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiListResponse;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiSpecie;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiStat;
import com.example.poke.pokeApi.models.ExternalApi.PokemonInfoApiResponse;

public interface PokemonApiRepositoryInterface {
    //get all the pokemons 
    public PokemonApiListResponse getAllPokemons(String limit, String offset);
    //call the external api https://pokeapi.co/api/v2/pokemon/id to get information about a pokemon
    public PokemonInfoApiResponse getPokemonInfo(String name);
    //call the external api https://pokeapi.co/api/v2/evolution-chain/{id}/ to get information about the pokemon's evolutions
    public PokemonApiChainEvolution getEvolutions(String url);
    //calculate the pokemon's characteristic ID 
    public int getPokemonCharacteristicID(ArrayList<PokemonApiStat> stats);
    //call the external api https://pokeapi.co/api/v2/characteristic/{id}/ to get information about the pokemon's description
    public PokemonApiCharacteristic getPokemonCharacteristics(int id);
    //call the external api https://pokeapi.co/api/v2/pokemon-species/{id or name}/
    //this method is important to get the pokemon's evolutions
    public PokemonApiSpecie getPokemonSpecie(String name);
}
