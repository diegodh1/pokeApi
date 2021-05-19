package com.example.poke.pokeApi.models.ExternalApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiEvolution1 {
    
    //attributes
    @JsonAlias("is_baby")
    private Boolean isBaby;
    private PokemonApiGenericResponse species;
    @JsonAlias("evolves_to")
    private ArrayList<PokemonApiEvolution2> evolvesTo;

    //empty constructor
    public PokemonApiEvolution1(){

    }

    //constructor
    public PokemonApiEvolution1(Boolean isBaby,PokemonApiGenericResponse species, ArrayList<PokemonApiEvolution2> evolvesTo){
        this.isBaby = isBaby;
        this.species = species;
        this.evolvesTo = evolvesTo;
    }

    //setters

    public void setIsBaby(Boolean value){
        this.isBaby = value;
    }

    public void setSpecies(PokemonApiGenericResponse value){
        this.species = value;
    }

    public void setEvolvesTo(ArrayList<PokemonApiEvolution2> value){
        this.evolvesTo = value;
    }

    //getters

    public Boolean getIsBaby(){
        return isBaby;
    }

    public PokemonApiGenericResponse getSpecies(){
        return species;
    }

    public ArrayList<PokemonApiEvolution2> getEvolvesTo(){
        return evolvesTo;
    }
    
}
