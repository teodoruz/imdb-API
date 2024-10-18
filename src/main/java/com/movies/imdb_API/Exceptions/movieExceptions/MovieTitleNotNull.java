package com.movies.imdb_API.Exceptions.movieExceptions;

public class MovieTitleNotNull extends RuntimeException {
    public MovieTitleNotNull(String message){
        super(message);
    }
}
