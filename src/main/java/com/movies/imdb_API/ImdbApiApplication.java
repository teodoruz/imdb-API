package com.movies.imdb_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class ImdbApiApplication {
	public static void main(String[] args) {

		SpringApplication.run(ImdbApiApplication.class, args);

	}
}
