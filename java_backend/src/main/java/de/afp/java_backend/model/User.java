package de.afp.java_backend.model;

import java.util.Collection;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    @Column(unique = true)
    String userName;
    @Column(unique = true)
    String email;
    String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Role> role;

    public User(){}

    public User(Long userId, String userName, String email, String password){
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public Long getUserId(){
        return this.userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public Collection<Role> getRole(){
        return this.role;
    }
    public void setRole(Collection<Role> role){
        this.role = role;
    }

}
