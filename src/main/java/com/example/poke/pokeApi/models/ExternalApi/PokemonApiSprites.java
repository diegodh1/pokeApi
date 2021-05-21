package com.example.poke.pokeApi.models.ExternalApi;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiSprites {

    //variables
    @JsonAlias("front_shiny")
    private String frontShiny;
    @JsonAlias("front_default")
    private String frontDefault;
    private PokemonApiOther other;
    //empty constructor
    public PokemonApiSprites(){

    }

    //constructor
    public PokemonApiSprites(String frontShiny, String frontDefault, PokemonApiOther other){
        this.frontShiny = frontShiny;
        this.frontDefault = frontDefault;
        this.other = other;
    }

    //setters
    public void setFrontShiny(String value){
        this.frontShiny = value;
    }
    
    public void setFrontDefault(String value){
        this.frontDefault = value;
    }

    public void setOther(PokemonApiOther value){
        this.other = value;
    }
    //getters

    public String getFrontShiny(){
        return this.frontShiny;
    }
    public String getFrontDefault(){
        return this.frontDefault;
    }

    public PokemonApiOther getOther(){
        return this.other;
    }
}
