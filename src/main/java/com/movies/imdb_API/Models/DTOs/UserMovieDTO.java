package com.movies.imdb_API.Models.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMovieDTO {
    private Long user;
    private Long movie;
    private  String hate;
}
