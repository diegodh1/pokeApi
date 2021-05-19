package com.example.poke.pokeApi.models.ExternalApi;

import java.util.ArrayList;

public class PokemonApiCharacteristic {

    //attributes
    private ArrayList<PokemonApiDescription> descriptions;

    //empty constructor
    public PokemonApiCharacteristic(){

    }

    //constructor
    public PokemonApiCharacteristic(ArrayList<PokemonApiDescription> descriptions){
        this.descriptions = descriptions;
    }

    //setter
    public void setDescriptions(ArrayList<PokemonApiDescription> value){
        this.descriptions = value;
    }

    //getter
    public ArrayList<PokemonApiDescription> getDescriptions(){
        return descriptions;
    }
}
