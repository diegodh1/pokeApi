package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PokemonApiEvolution2 {

    //attributes
    @JsonAlias("is_baby")
    private Boolean isBaby;
    private PokemonApiGenericResponse species;

    //empty constructor
    public PokemonApiEvolution2(){

    }

    //constructor
    public PokemonApiEvolution2(Boolean isBaby,PokemonApiGenericResponse species){
        this.isBaby = isBaby;
        this.species = species;
    }

    //setters

    public void setIsBaby(Boolean value){
        this.isBaby = value;
    }

    public void setSpecies(PokemonApiGenericResponse value){
        this.species = value;
    }

    //getters

    public Boolean getIsBaby(){
        return isBaby;
    }

    public PokemonApiGenericResponse getSpecies(){
        return species;
    }
    
}
