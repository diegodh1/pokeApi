package com.example.poke.pokeApi.models;
import java.util.ArrayList;

public class Pokemon {
    //attributes
    private String name;
    private String photo;
    private String type;
    private ArrayList<String> abilities;
    private String description;
    private ArrayList<String> evolutions;

    //constructor
    public Pokemon(String name, String photo, String type, ArrayList<String> abilities, String description, ArrayList<String> evolutions){
        this.name = name;
        this.photo = photo;
        this.type = type;
        this.abilities = abilities;
        this.description = description;
        this.evolutions = evolutions;
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

    //set type value
    public void setType(String value){
        this.type = value;
    }

    //set abilities value
    public void setAbilities(ArrayList<String> value){
        this.abilities = value;
    }

    //set description value
    public void setDescription(String value){
        this.description = value;
    }

    //set evolutions value
    public void setEvolutions(ArrayList<String> value){
        this.evolutions = value;
    }

    //getters

    //get the pokemon name
    public String getName(){
        return name;
    }
    //get the pokemon photo
    public String getPhoto(){
        return photo;
    }
    //get the pokemon type
    public String getType(){
        return type;
    }
    //get the pokemon abilities
    public ArrayList<String> getAbilities(){
        return abilities;
    }
    //get the pokemon description
    public String getDescription(){
        return description;
    }
    //get the pokemon evolutions
    public ArrayList<String> getEvolutions(){
        return evolutions;
    }

}
