package com.movies.imdb_API.Exceptions.userExceptions;


public class UsernameAlreadyExists extends RuntimeException{

    public UsernameAlreadyExists(String message){
        super(message);
    }
}
