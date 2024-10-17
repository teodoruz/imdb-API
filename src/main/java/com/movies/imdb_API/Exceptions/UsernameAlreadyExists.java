package com.movies.imdb_API.Exceptions;


public class UsernameAlreadyExists extends RuntimeException{

    public UsernameAlreadyExists(String message){
        super(message);
    }
}
