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

import de.afp.java_backend.model.PostModel;
import de.afp.java_backend.model.Role;
import de.afp.java_backend.model.User;
import de.afp.java_backend.service.PostService;

@RestController
@RequestMapping(path = "/post")
public class PostController {
    private final PostService POSTSERVICE;

    @Autowired
    public PostController(PostService POSTSERVICE){
        this.POSTSERVICE = POSTSERVICE;
    }
    @GetMapping(value="/all")
    public ResponseEntity<List<PostModel>> allPost() {
        return new ResponseEntity<List<PostModel>>(POSTSERVICE.allPost(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<PostModel> savePost(@RequestBody PostModel post){
        POSTSERVICE.savePost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id){
        POSTSERVICE.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<PostModel> updatePost(@RequestBody PostModel post){
        POSTSERVICE.updatePost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<PostModel>> findPostById(@PathVariable("id") Long id){
        return new ResponseEntity<Optional<PostModel>>(POSTSERVICE.findPostById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/count/{id}")
    public ResponseEntity<?> countPostByUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(POSTSERVICE.countPostByUser(id), HttpStatus.OK);
    }
}
