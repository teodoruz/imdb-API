package com.movies.imdb_API.Controllers;

import com.movies.imdb_API.Models.DTOs.MovieDTO;
import com.movies.imdb_API.Models.DTOs.UserDTO;
import com.movies.imdb_API.Models.Movie;
import com.movies.imdb_API.Models.User;
import com.movies.imdb_API.Repository.MovieRepository;
import com.movies.imdb_API.Service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path="/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    @PostMapping
    public ResponseEntity<Movie> postMovie(@RequestBody MovieDTO movieDTO){
        return movieService.insertMovie(movieDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> listMovie(){
        return movieService.findAllMovies();
    }

    @GetMapping("/{idmovie}")
    public ResponseEntity<Movie> findMovieById(@PathVariable long idmovie){
        return movieService.findById(idmovie);
    }
}
