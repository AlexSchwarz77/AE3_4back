package de.afp.java_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.afp.java_backend.model.User;
import de.afp.java_backend.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService USERSERVICE;

    @Autowired
    public UserController(UserService USERSERVICE){
        this.USERSERVICE = USERSERVICE;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> allUser(){
        return new ResponseEntity<List<User>>(USERSERVICE.allUser(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        USERSERVICE.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        USERSERVICE.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        USERSERVICE.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") Long id){
        return new ResponseEntity<Optional<User>>(USERSERVICE.findUserById(id), HttpStatus.OK);
    }
    
}
