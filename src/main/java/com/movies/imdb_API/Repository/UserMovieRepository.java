package com.movies.imdb_API.Repository;

import com.movies.imdb_API.Models.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {
}
