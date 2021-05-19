package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiChainEvolution {

    //attributes
    @JsonAlias("chain")
    private PokemonApiEvolutions chain;

    //empty constructor
    public PokemonApiChainEvolution(){

    }
    
    //constructor
    public PokemonApiChainEvolution(PokemonApiEvolutions chain){
        this.chain = chain;
    }

    //setters

    public void setChain(PokemonApiEvolutions value){
        this.chain = value;
    }
    //getters

    public PokemonApiEvolutions getChain(){
        return chain;
    }

}
