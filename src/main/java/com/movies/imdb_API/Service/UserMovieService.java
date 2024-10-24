package com.movies.imdb_API.Service;

import com.movies.imdb_API.Models.DTOs.UserDTO;
import com.movies.imdb_API.Models.DTOs.UserMovieDTO;
import com.movies.imdb_API.Models.Movie;
import com.movies.imdb_API.Models.User;
import com.movies.imdb_API.Models.UserMovie;
import com.movies.imdb_API.Repository.UserMovieRepository;
import org.hibernate.boot.model.process.internal.UserTypeMutabilityPlanAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserMovieService {
    private final UserMovieRepository userMovieRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;

    public UserMovieService(UserMovieRepository userMovieRepository) {
        this.userMovieRepository = userMovieRepository;
    }
    public ResponseEntity<UserMovie> postUserMovie(@RequestBody UserMovieDTO umDTO){
        ResponseEntity<Movie> movie1 = movieService.findById(umDTO.getMovie());
        if(!movie1.getStatusCode().is2xxSuccessful()||movie1==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ResponseEntity<User> user1 = userService.getUserById(umDTO.getUser());
        UserMovie userMovie = new UserMovie();
        userMovie.setMovie(movie1.getBody());
        userMovie.setUser(user1.getBody());
        userMovie.setHate(umDTO.getHate());
        userMovieRepository.save(userMovie);
        return ResponseEntity.status(HttpStatus.OK).body(userMovie);

    }


}
