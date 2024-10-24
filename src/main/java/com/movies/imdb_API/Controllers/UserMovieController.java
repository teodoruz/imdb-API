package com.movies.imdb_API.Controllers;

import com.movies.imdb_API.Models.DTOs.UserMovieDTO;
import com.movies.imdb_API.Models.Movie;
import com.movies.imdb_API.Models.UserMovie;
import com.movies.imdb_API.Service.UserMovieService;
import com.movies.imdb_API.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/usermovie")
public class UserMovieController {
    private final UserMovieService userMovieService;

    public UserMovieController(UserMovieService userMovieService){
        this.userMovieService = userMovieService;
    }
    @PostMapping
    public ResponseEntity<UserMovie> postMovieUser(@RequestBody UserMovieDTO userMovie){
        return userMovieService.postUserMovie(userMovie);
    }
}
