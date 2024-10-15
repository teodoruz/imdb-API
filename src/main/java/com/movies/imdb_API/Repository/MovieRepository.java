package com.movies.imdb_API.Repository;

import com.movies.imdb_API.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
