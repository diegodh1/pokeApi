package com.example.poke.pokeApi.models.ExternalApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiEvolutions {

    //empty constructor
    @JsonAlias("evolves_to")
    private ArrayList<PokemonApiEvolution1> evolvesTo;
    @JsonAlias("is_baby")
    private Boolean isBaby;
    @JsonAlias("species")
    private PokemonApiGenericResponse species;

    //empty constructor
    public PokemonApiEvolutions(){

    }

    //constructor
    public PokemonApiEvolutions(ArrayList<PokemonApiEvolution1> evolvesTo, Boolean isBaby, PokemonApiGenericResponse species){
        this.evolvesTo = evolvesTo;
        this.isBaby = isBaby;
        this.species = species;
    }

    //setters
    public void setEvolvesTo(ArrayList<PokemonApiEvolution1> value){
        this.evolvesTo = value;
    }
    public void setIsBaby(Boolean value){
        this.isBaby = value;
    }
    public void setSpecies(PokemonApiGenericResponse value){
        this.species = value;
    }
    //getters
    public ArrayList<PokemonApiEvolution1> getEvolvesTo(){
        return this.evolvesTo;
    }

    public Boolean getIsBaby(){
        return this.isBaby;
    }

    public PokemonApiGenericResponse getSpecies(){
        return this.species;
    }
}
