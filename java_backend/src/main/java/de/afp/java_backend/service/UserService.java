package de.afp.java_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;

import de.afp.java_backend.model.User;
import de.afp.java_backend.repository.UserRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    public final UserRepo USERREPO;

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
    
    public Boolean validatePassword(User user){
        Optional<User> pwUser = USERREPO.findById(user.getUserId());
        User dbUser = pwUser.get();
        
        if (BCrypt.verifyer().verify(user.getPassword().toCharArray(), dbUser.getPassword()).verified) {
            System.out.println("pw right");
            return true;
        }
        return false;

    }
}
