package com.example.poke.pokeApi.models.Exceptions;

public class ApiResponseError extends RuntimeException{
    
    public ApiResponseError(String message){
        super(message);
    }
}
