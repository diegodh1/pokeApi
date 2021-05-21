package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiPhoto {

    //variables
    @JsonAlias("front_default")
    private String frontDefault;

    //empty constructor
    public PokemonApiPhoto(){

    }
    //constructor
    public PokemonApiPhoto(String frontDefault){
        this.frontDefault = frontDefault;
    }

    //setters
    public void setFrontDefault(String value){
        this.frontDefault = value;
    }


    //getters
    public String getFrontDefault(){
        return frontDefault;
    }
}
