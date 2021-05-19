package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiGenericResponse {
    //attributes
    private String name;
    private String url;
    
    //Constructor
    public PokemonApiGenericResponse(String name, String url){
        this.name = name;
        this.url = url;
    }

    //empty constructor
    public PokemonApiGenericResponse(){
        
    }

    //setters

    //set name value
    public void setName(String value){
        this.name = value;
    }
    //set url value
    public void setUrl(String value){
        this.url = value;
    }

    //getters
    
    //get the name
    public String getName(){
        return name;
    }
    //get the url
    public String getUrl(){
        return url;
    }
}
