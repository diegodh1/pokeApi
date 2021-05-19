package com.example.poke.pokeApi.models.ExternalApi;

import java.util.ArrayList;

public class PokemonInfoApiResponse {
    
    //attributes
    private ArrayList<PokemonApiAbility> abilities;
    private int height;
    private int weight;
    private int id;
    private String name;
    private ArrayList<PokemonApiType> types;
    private PokemonApiSprites sprites;
    private ArrayList<PokemonApiStat> stats;

    //empty constructor
    public PokemonInfoApiResponse(){

    }

    //constructor
    public PokemonInfoApiResponse(ArrayList<PokemonApiAbility> abilities, int height, int weight, int id, String name, ArrayList<PokemonApiType> types, PokemonApiSprites sprites, ArrayList<PokemonApiStat>  stats){
        this.abilities = abilities;
        this.height = height;
        this.weight = weight;
        this.id = id;
        this.name = name;
        this.types = types;
        this.sprites = sprites;
        this.stats = stats;
    }

    //setters
    public void setAbilities(ArrayList<PokemonApiAbility> value){
        this.abilities = value;
    }

    public void setHeight(int value){
        this.height = value;
    }

    public void setWeight(int value){
        this.weight = value;
    }

    public void setID(int value){
        this.id = value;
    }
    
    public void setName(String value){
        this.name = value;
    }

    public void setTypes(ArrayList<PokemonApiType> value){
        this.types = value;
    }

    public void setSprites(PokemonApiSprites value){
        this.sprites = value;
    }

    public void setStats(ArrayList<PokemonApiStat>  value){
        this.stats = value;
    }



    //getters
    public ArrayList<PokemonApiAbility> getAbilities(){
        return this.abilities;
    }

    public int getHeight(){
        return this.height;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<PokemonApiType> getTypes(){
        return this.types;
    }

    public PokemonApiSprites getSprites(){
        return this.sprites;
    }

    public ArrayList<PokemonApiStat>  getStats(){
        return stats;
    }

}
