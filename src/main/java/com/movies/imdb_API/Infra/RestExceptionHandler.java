package com.movies.imdb_API.Infra;

import com.movies.imdb_API.Exceptions.UsernameAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExists.class)
    public ResponseEntity<String> usernameAlreadyExists(UsernameAlreadyExists u){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("User name already exist");
    }
}
