package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiOther {
    //attributes
    @JsonAlias("dream_world")
    private PokemonApiPhoto dreamWorld;
    @JsonAlias("official-artwork")
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

    //toString
    @Override
    public String toString(){
        return String.format("PokemonApiOther{dreamWorld=%s, officialArtwork=%s}", this.dreamWorld.toString(), this.officialArtwork.toString());
    }
    
}
