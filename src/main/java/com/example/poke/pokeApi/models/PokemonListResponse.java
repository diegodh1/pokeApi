package com.example.poke.pokeApi.models;
import java.util.ArrayList;

public class PokemonListResponse {
    private int count;
    private String next;
    private String previous;
    private ArrayList<Pokemon> results;

    //constructor
    public PokemonListResponse(int count, String next, String previous, ArrayList<Pokemon> results){
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    //empty constructor
    public PokemonListResponse(){

    }

    //setters

    //set the value of count
    public void setCount(int value){
        this.count = value;
    }

    //set the value of next
    public void setNext(String value){
        this.next = value;
    }

    //set the value of previous
    public void setPrevious(String value){
        this.previous = value;
    }

    //set the value of results
    public void setResults(ArrayList<Pokemon> value){
        this.results = value;
    }

    //getters
    public int getCount(){
        return this.count;
    }

    public String getNext(){
        return this.next;
    }

    public String getPrevious(){
        return this.previous;
    }

    public ArrayList<Pokemon> getResults(){
        return this.results;
    }
    
}
