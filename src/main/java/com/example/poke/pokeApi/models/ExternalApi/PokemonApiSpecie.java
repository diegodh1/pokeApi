package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiSpecie {

    //attributes
    @JsonAlias("evolution_chain")
    private PokemonApiGenericResponse evolutionChain;

    //empty constructor
    public PokemonApiSpecie(){

    }

    //constructor
    public PokemonApiSpecie(PokemonApiGenericResponse evolutionChain){
        this.evolutionChain = evolutionChain;
    }

    //setter
    public void setEvolutionChain(PokemonApiGenericResponse value){
        this.evolutionChain = value;
    }

    //gettes
    public PokemonApiGenericResponse getEvolutionChain(){
        return this.evolutionChain;
    }

}
