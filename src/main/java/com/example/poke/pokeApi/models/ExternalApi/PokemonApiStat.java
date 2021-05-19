package com.example.poke.pokeApi.models.ExternalApi;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PokemonApiStat {

    //attributes
    @JsonAlias("base_stat")
    private int baseStat;
    private int effort;
    private PokemonApiGenericResponse stat;

    //empty constructor
    public PokemonApiStat(){

    }

    //constructor
    public PokemonApiStat(int baseStat, int effort, PokemonApiGenericResponse stat){
        this.baseStat = baseStat;
        this.effort = effort;
        this.stat = stat;
    }

    //setter
    public void setBaseStat(int value){
        this.baseStat = value;
    }

    public void setEffort(int value){
        this.effort = value;
    }

    public void setStat(PokemonApiGenericResponse value){
        this.stat = value;
    }

    //getters
    public int getBaseStat(){
        return baseStat;
    }

    public int getEffort(){
        return effort;
    }

    public PokemonApiGenericResponse getStat(){
        return stat;
    }

}
