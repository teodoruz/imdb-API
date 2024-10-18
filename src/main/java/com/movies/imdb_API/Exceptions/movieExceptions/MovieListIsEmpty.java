package com.movies.imdb_API.Exceptions.movieExceptions;

public class MovieListIsEmpty extends RuntimeException{
    public MovieListIsEmpty(String message){
        super(message);
    }
}
