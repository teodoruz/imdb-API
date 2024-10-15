package com.movies.imdb_API.Exceptions;


public class UsernameAlreadyExists extends RuntimeException{

    public UsernameAlreadyExists(){
        super("User name already exists");
    }
    public UsernameAlreadyExists(String message){
        super(message);
    }
}
