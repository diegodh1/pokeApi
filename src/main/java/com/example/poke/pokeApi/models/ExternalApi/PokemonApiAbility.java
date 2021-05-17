package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiAbility {

    private PokemonApiGenericResponse ability;
    @JsonAlias("is_hidden")
    private Boolean isHidden;
    private int slot;

    //empty constructor
    public PokemonApiAbility(){}

    //constructor
    public PokemonApiAbility(PokemonApiGenericResponse ability, Boolean isHidden, int slot){
        this.ability = ability;
        this.isHidden = isHidden;
        this.slot = slot;
    }

    //setters

    public void setAbility(PokemonApiGenericResponse value){
        this.ability = value;
    }

    public void setIsHidden(Boolean value){
        this.isHidden = value;
    }

    public void setSlot(int value){
        this.slot = value;
    }

    //getters

    public PokemonApiGenericResponse getAbility(){
        return ability;
    }

    public Boolean getIsHidden(){
        return isHidden;
    }

    public int getSlot(){
        return slot;
    }

    //TO STRING
    @Override
    public String toString(){
        return String.format("PokemonApiAbility{ability = %s, isHidden=%b, slot=%d}", ability.toString(), this.isHidden, slot);
    }
}
