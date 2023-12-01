package de.afp.java_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.afp.java_backend.model.Role;
import de.afp.java_backend.repository.RoleRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleService {
    private final RoleRepo ROLEREPO;

    public RoleService(RoleRepo ROLEREPO){
        this.ROLEREPO = ROLEREPO;
    }

    public List<Role> allRoles(){
        return ROLEREPO.findAll();
    }

    public void saveRole(Role role){
        ROLEREPO.save(role);
    }

    public void deleteRoleById(Long id){
        ROLEREPO.deleteById(id);
    }

    public void updateRole(Role role){
        ROLEREPO.save(role);
    }

    public Optional<Role> findRoleById(Long id){
        return ROLEREPO.findById(id);
    }
}
