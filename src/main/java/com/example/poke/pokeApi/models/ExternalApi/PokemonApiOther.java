package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiOther {
    //variables
    @JsonAlias("dream_world")
    private PokemonApiPhoto dreamWorld;
    @JsonProperty("official-artwork")
    private PokemonApiPhoto officialArtwork;

    //empty constructor
    public PokemonApiOther(){

    }

    //constructor
    public PokemonApiOther(PokemonApiPhoto dreamWorld, PokemonApiPhoto officialArtwork){
        this.dreamWorld = dreamWorld;
        this.officialArtwork = officialArtwork;
    }

    //setters
    public void setDreamWorld(PokemonApiPhoto value){
        this.dreamWorld = value;
    }

    public void setOfficialArtWork(PokemonApiPhoto value){
        this.officialArtwork = value;
    }

    //getters
    public PokemonApiPhoto getDreamWorld(){
        return this.dreamWorld;
    }

    public PokemonApiPhoto getOfficialArtWork(){
        return this.officialArtwork;
    }

}
