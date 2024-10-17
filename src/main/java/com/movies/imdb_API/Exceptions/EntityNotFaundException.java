package com.movies.imdb_API.Exceptions;

public class EntityNotFaundException extends RuntimeException {

    public EntityNotFaundException(String message){
        super(message);
    }
}
