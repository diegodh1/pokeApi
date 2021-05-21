package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiGenericResponse {
    //variables
    private String name;
    private String url;
    
    //Constructor
    public PokemonApiGenericResponse(String name, String url){
        //name of the property
        this.name = name;
        //to get more information url of the property
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
