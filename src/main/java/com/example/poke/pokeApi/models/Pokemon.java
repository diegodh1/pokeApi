package com.example.poke.pokeApi.models;
import java.util.ArrayList;

import com.example.poke.pokeApi.models.ExternalApi.PokemonApiAbility;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiChainEvolution;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiDescription;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiStat;
import com.example.poke.pokeApi.models.ExternalApi.PokemonApiType;

public class Pokemon {
    //attributes
    private String name;
    private String photo;
    private int height;
    private int weight;
    private ArrayList<PokemonApiType> types;
    private ArrayList<PokemonApiAbility> abilities;
    private PokemonApiChainEvolution evolutions;
    private ArrayList<PokemonApiStat> stats;
    private ArrayList<PokemonApiDescription> descriptions;

    //empty constructor
    public Pokemon(){

    }

    //constructor
    public Pokemon(String name, String photo,int height, int weight, ArrayList<PokemonApiType> types, ArrayList<PokemonApiAbility> abilities, ArrayList<PokemonApiStat> stats, PokemonApiChainEvolution evolutions, ArrayList<PokemonApiDescription> descriptions){
        this.name = name;
        this.photo = photo;
        this.height = height;
        this.weight = weight;
        this.types = types;
        this.abilities = abilities;
        this.stats = stats;
        this.evolutions = evolutions;
        this.descriptions = descriptions;
    }
     
    //setters

    //set name value
    public void setName(String value){
        this.name = value;
    }
    
    //set photo value
    public void setPhoto(String value){
        this.photo = value;
    }
    //set height
    public void setHeight(int value){
        this.height = value;
    }

    //set weight
    public void setWeight(int value){
        this.weight = value;
    }

    //set type value
    public void setTypes(ArrayList<PokemonApiType> value){
        this.types = value;
    }

    //set abilities value
    public void setAbilities(ArrayList<PokemonApiAbility> value){
        this.abilities = value;
    }

    //set description value
    public void setDescriptions(ArrayList<PokemonApiDescription> value){
        this.descriptions = value;
    }

    //set stats value
    public void setStats(ArrayList<PokemonApiStat> value){
        this.stats = value;
    }

    //set evolutions value
    public void setEvolutions(PokemonApiChainEvolution value){
        this.evolutions = value;
    }

    //getters

    //get the pokemons name
    public String getName(){
        return name;
    }
    //get the pokemons photo
    public String getPhoto(){
        return photo;
    }
    //get the pokemons height
    public int getHeight(){
        return height;
    }

    //get the pokemons height
    public int getWeight(){
        return weight;
    }

    //get the pokemons type
    public ArrayList<PokemonApiType> getType(){
        return types;
    }
    //get the pokemons abilities
    public ArrayList<PokemonApiAbility> getAbilities(){
        return abilities;
    }
    //get the pokemons description
    public ArrayList<PokemonApiDescription>  getDescriptions(){
        return descriptions;
    }
    //get the pokemon's stats
    public ArrayList<PokemonApiStat> getStats(){
        return stats;
    }
    //get the pokemons evolutions
    public PokemonApiChainEvolution getEvolutions(){
        return evolutions;
    }

}
