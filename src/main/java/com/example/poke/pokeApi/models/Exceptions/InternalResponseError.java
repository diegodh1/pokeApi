package com.example.poke.pokeApi.models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalResponseError extends RuntimeException{
    public InternalResponseError(String message){
        super(message);
    }
}