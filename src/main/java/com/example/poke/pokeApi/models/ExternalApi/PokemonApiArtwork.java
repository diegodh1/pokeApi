package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiArtwork {
    //attributes
    private PokemonApiPhoto officialArtWork;

    //empty constructor
    public PokemonApiArtwork(){

    }

    //constructor
    public PokemonApiArtwork(PokemonApiPhoto officialArtWork){
        this.officialArtWork = officialArtWork;
    }

    //setters
    public void setOfficialArtWork(PokemonApiPhoto value){
        this.officialArtWork = value;
    }
    
    //getters
    public PokemonApiPhoto getOfficialArtWork(){
        return officialArtWork;
    }

    //toString
    @Override
    public String toString(){
        return String.format("PokemonApiArtwork{officialArtWork=%s}", officialArtWork.toString());
    }
}
