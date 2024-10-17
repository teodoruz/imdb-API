package com.movies.imdb_API.Service;

import com.movies.imdb_API.Exceptions.EntityNotFaundException;
import com.movies.imdb_API.Exceptions.UsernameAlreadyExists;
import com.movies.imdb_API.Models.DTOs.UserDTO;
import com.movies.imdb_API.Models.User;
import com.movies.imdb_API.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> postUser(@RequestBody UserDTO userDTO){
        User user = new User();
        this.toDTO(userDTO, user);
        if(userRepository.existsByUsername(userDTO.getUsername())){
            throw new UsernameAlreadyExists("User Already exists");
            }
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public ResponseEntity<User> getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFaundException("e"));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public void toDTO(UserDTO userDTO, User user){
    user.setEmail(userDTO.getEmail());
    user.setUsername(userDTO.getUsername());
    user.setPassword(userDTO.getPassword());
    }

}
