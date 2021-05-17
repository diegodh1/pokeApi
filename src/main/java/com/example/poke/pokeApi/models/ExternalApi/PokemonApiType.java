package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiType {
    private int slot;
    private PokemonApiGenericResponse type;

    //constructor
    public PokemonApiType(int slot, PokemonApiGenericResponse type){
        this.slot = slot;
        this.type = type;
    }
    //empty constructor
    public PokemonApiType(){

    }

    //setters

    public void setSlot(int value){
        this.slot = value;
    }
    public void setType(PokemonApiGenericResponse value){
        this.type = value;
    }

    //getters
    public int getSlot(){
        return slot;
    }

    public PokemonApiGenericResponse getType(){
        return type;
    }

    //toString
    @Override
    public String toString(){
        return String.format("PokemonApiType{slot=%d, type=%s}", slot, type);
    }

}
