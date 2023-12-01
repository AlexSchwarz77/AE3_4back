package de.afp.java_backend.controller;

import java.util.List;
import java.util.Optional;

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

import de.afp.java_backend.model.Subforum;
import de.afp.java_backend.service.SubforumService;

@RestController
@RequestMapping(path = "/subforum")
public class SubforumController {
    private final SubforumService SUBSERVICE;

    public SubforumController(SubforumService SUBSERVICE){
        this.SUBSERVICE = SUBSERVICE;
    }
    @GetMapping(value="/all")
    public ResponseEntity<List<Subforum>> allSub() {
        return new ResponseEntity<List<Subforum>>(SUBSERVICE.allSub(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Subforum> saveSub(@RequestBody Subforum subforum){
        SUBSERVICE.saveSub(subforum);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteSub(@PathVariable("id") Long id){
        SUBSERVICE.deleteSub(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Subforum> updateSub(@RequestBody Subforum subforum){
        SUBSERVICE.updateSub(subforum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Subforum>> findSubById(@PathVariable("id") Long id){
        return new ResponseEntity<Optional<Subforum>>(SUBSERVICE.findSubById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Optional<Subforum>> getSubByName(@PathVariable("name") String name){
        return new ResponseEntity<Optional<Subforum>>(SUBSERVICE.findSubByName(name), HttpStatus.OK);
    }

    
}
