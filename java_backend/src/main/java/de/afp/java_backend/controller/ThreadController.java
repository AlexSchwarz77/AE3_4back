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

import de.afp.java_backend.model.ThreadModel;
import de.afp.java_backend.service.ThreadService;

@RestController
@RequestMapping(path = "/thread")
public class ThreadController {
    private final ThreadService THREADSERVICE;

    @Autowired
    public ThreadController(ThreadService THREADSERVICE){
        this.THREADSERVICE = THREADSERVICE;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ThreadModel>> allThread(){
        return new ResponseEntity<List<ThreadModel>>(THREADSERVICE.allThread(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ThreadModel> saveThread(@RequestBody ThreadModel thread){
        THREADSERVICE.saveThread(thread);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteThread(@PathVariable("id") Long id){
        THREADSERVICE.deleteThread(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ThreadModel> updateThread(@RequestBody ThreadModel thread){
        THREADSERVICE.updateThread(thread);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ThreadModel>> findThreadById(@PathVariable("id") Long id){
        return new ResponseEntity<Optional<ThreadModel>>(THREADSERVICE.findThreadById(id), HttpStatus.OK);
    }
    
}
