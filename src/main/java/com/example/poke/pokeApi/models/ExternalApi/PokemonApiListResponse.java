package com.example.poke.pokeApi.models.ExternalApi;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonApiListResponse {
    //variables
    private int count;
    private String next;
    private String previous;
    private ArrayList<PokemonApiGenericResponse> results;

    
    //constructor
    public PokemonApiListResponse(int count, String next, String previous, ArrayList<PokemonApiGenericResponse> results){
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    //empty constructor
    public PokemonApiListResponse(){

    }

    //setters

    //set count value
    public void setCount(int value){
        this.count = value;
    }

    //set next value
    public void setNext(String value){
        this.next = value;
    }

    //set previous value
    public void setPrevious(String value){
        this.previous = value;
    }

    //set results value
    public void setResults(ArrayList<PokemonApiGenericResponse> value){
        this.results = value;
    }

    //getters

    //get count
    public int getCount(){
        return count;
    }
    //get next
    public String getNext(){
        return next;
    }
    //get previous
    public String getPrevious(){
        return previous;
    }
    //get generic results
    public ArrayList<PokemonApiGenericResponse> getResults(){
        return results;
    } 

}
