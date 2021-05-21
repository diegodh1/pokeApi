package com.example.poke.pokeApi.models.ExternalApi;

public class PokemonApiDescription {
    
    //variables
    private String description;
    private PokemonApiGenericResponse language;

    //empty constructor
    public PokemonApiDescription(){
    }

    //constructor
    public PokemonApiDescription(String description, PokemonApiGenericResponse language){
        this.description = description;
        this.language = language;
    }

    //setters
    public void setDescription(String value){
        this.description = value;
    }

    public void setLanguage(PokemonApiGenericResponse value){
        this.language = value;
    }

    //getters

    public String getDescription() {
        return this.description;
    }

    public PokemonApiGenericResponse getLanguage() {
        return this.language;
    }
    
}
