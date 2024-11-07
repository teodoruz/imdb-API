package com.movies.imdb_API.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.imdb_API.Exceptions.EntityNotFaundException;
import com.movies.imdb_API.Exceptions.movieExceptions.MovieListIsEmpty;
import com.movies.imdb_API.Exceptions.movieExceptions.MovieTitleNotNull;
import com.movies.imdb_API.Models.DTOs.MovieDTO;
import com.movies.imdb_API.Models.Movie;
import com.movies.imdb_API.Repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    private static final String API_KEY = "2429b5675c7e2894e0d8a79557c49e13";
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    public ResponseEntity<Movie> insertMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = new Movie();
        this.toDTO(movieDTO, movie);
        if (movieDTO.getTitle().isEmpty()) {
            throw new MovieTitleNotNull("Title cannot be null");
        }
        movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movieList;
        movieList = movieRepository.findAll();
        if (movieList.isEmpty()) {
            throw new MovieListIsEmpty("List null");
        }
        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

    public ResponseEntity<Movie> findById(@PathVariable Long idmovie) {
        Movie movie = movieRepository.findById(idmovie).orElseThrow(() -> new EntityNotFaundException("error"));
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    public void toDTO(MovieDTO movieDTO, Movie movie) {
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());
        movie.setProducer(movieDTO.getProducer());
    }

    public ResponseEntity<JsonNode> getPopularMovies() throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            String endpoint = BASE_URL + "/movie/popular?api_key=" + API_KEY;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode responseJson = mapper.readTree(response.body());
            return ResponseEntity.status(HttpStatus.OK).body(responseJson);

    }


}
