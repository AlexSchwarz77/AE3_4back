package de.afp.java_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.afp.java_backend.model.Role;
import de.afp.java_backend.service.RoleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "/role")
public class RoleController {
    private final RoleService ROLESERVICE;

    @Autowired
    public RoleController(RoleService ROLESERVICE){
        this.ROLESERVICE = ROLESERVICE;
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<Role>> allRoles() {
        return new ResponseEntity<List<Role>>(ROLESERVICE.allRoles(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        ROLESERVICE.saveRole(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") Long id){
        ROLESERVICE.deleteRoleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        ROLESERVICE.updateRole(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Role>> findRoleById(@PathVariable("id") Long id){
        return new ResponseEntity<Optional<Role>>(ROLESERVICE.findRoleById(id), HttpStatus.OK);
    }

    
    
    
}
