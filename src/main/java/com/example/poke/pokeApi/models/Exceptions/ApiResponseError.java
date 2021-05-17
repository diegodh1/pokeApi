package com.example.poke.pokeApi.models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiResponseError extends RuntimeException{
    
    public ApiResponseError(String message){
        super(message);
    }
}
