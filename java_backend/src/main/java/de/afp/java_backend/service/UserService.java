package de.afp.java_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.afp.java_backend.model.Subforum;
import de.afp.java_backend.model.User;
import de.afp.java_backend.repository.UserRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    public final UserRepo USERREPO;

    @Autowired
    public UserService(UserRepo USERREPO){
        this.USERREPO = USERREPO;
    }

    public List<User> allUser(){
        return USERREPO.findAll();
    }

    public void saveUser(User user){
        this.USERREPO.save(user);
    }

    public void deleteUserById(Long id){
        this.USERREPO.deleteById(id);
    }

    public User updateUser(User user){
        return USERREPO.save(user);
    }

    public Optional<User> findUserById(Long id){
        return USERREPO.findById(id);
    }   
}
