package com.movies.imdb_API.Infra;

import com.movies.imdb_API.Exceptions.EntityNotFaundException;
import com.movies.imdb_API.Exceptions.movieExceptions.MovieListIsEmpty;
import com.movies.imdb_API.Exceptions.movieExceptions.MovieTitleNotNull;
import com.movies.imdb_API.Exceptions.userExceptions.UsernameAlreadyExists;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExists.class)
    public ResponseEntity<StandardError> usernameAlreadyExists(UsernameAlreadyExists u, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        String error = "user name already exists";
        StandardError standardError = new StandardError(Instant.now().toString(), error, u.getMessage(), request.getRequestURI(), status.toString());
        return  ResponseEntity.status(status).body(standardError);
    }
    @ExceptionHandler(EntityNotFaundException.class)
    public ResponseEntity<StandardError> entityNotFaundException(EntityNotFaundException u, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Entity not faund in database";
        StandardError standardError = new StandardError(Instant.now().toString(), error, u.getMessage(), request.getRequestURI(), status.toString());
        return ResponseEntity.status(status).body(standardError);
    }
    @ExceptionHandler(MovieTitleNotNull.class)
    public ResponseEntity<StandardError> movieTitleNotNull(MovieTitleNotNull m, HttpServletRequest request){
        HttpStatus status = HttpStatus.NO_CONTENT;
        String error = "Movie title cannot be null";
        StandardError standardError = new StandardError(Instant.now().toString(),error, m.getMessage(), request.getRequestURI(), status.toString());
        return ResponseEntity.status(status).body(standardError);
    }
    @ExceptionHandler(MovieListIsEmpty.class)
    public ResponseEntity<StandardError> movieListIsEmpty(MovieListIsEmpty m, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "The list is empty";
        StandardError standardError = new StandardError(Instant.now().toString(),error,m.getMessage(),request.getRequestURI(),status.toString());
        return ResponseEntity.status(status).body(standardError);
    }
}
