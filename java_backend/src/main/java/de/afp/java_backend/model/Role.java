package de.afp.java_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(unique = true)
    private String role;

    public Role(){}

    public Role(Long roleId, String role){
        this.roleId = roleId;
        this.role = role;
    }

    public Long getRoleId(){
        return this.roleId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }
}
