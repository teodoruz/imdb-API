package com.movies.imdb_API.Controllers;

import com.movies.imdb_API.Models.DTOs.UserDTO;
import com.movies.imdb_API.Models.User;
import com.movies.imdb_API.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody UserDTO userDTO){
        return userService.postUser(userDTO);
    }
    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable long idUser){
        return userService.getUserById(idUser);
    }
}
