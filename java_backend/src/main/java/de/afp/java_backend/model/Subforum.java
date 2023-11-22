package de.afp.java_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Subforum {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subForumId;
    @Column(unique = true)
    private String subName;
    
    public Subforum(){}

    public Subforum(Long subForumId, String subName){
        this.subForumId = subForumId;
        this.subName = subName;
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
}
