package de.afp.java_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Subforum {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subForumId;
    @Column(unique = true)
    private String subName;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    
    public Subforum(){}

    public Subforum(Long subForumId, String subName, User user){
        this.subForumId = subForumId;
        this.subName = subName;
        this.user = user;
    }

    public Long getSubForumID(){
        return this.subForumId;
    }

    public String getSubName(){
        return this.subName;
    }

    public void setSubName(String subName){
        this.subName = subName;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
