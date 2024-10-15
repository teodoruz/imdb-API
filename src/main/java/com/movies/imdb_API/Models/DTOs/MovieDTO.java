package com.movies.imdb_API.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;

@Getter
@Setter
@AllArgsConstructor
public class MovieDTO {
    private Long movieId;
    private String title;
    private String genre;
    private String producer;
}
