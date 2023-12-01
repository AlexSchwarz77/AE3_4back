package de.afp.java_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.afp.java_backend.model.Subforum;
import de.afp.java_backend.repository.SubforumRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubforumService {
    private final SubforumRepo SUBREPO;
    

    public SubforumService(SubforumRepo SUBREPO){
        this.SUBREPO = SUBREPO;
    }

    public List<Subforum> allSub(){
        return SUBREPO.findAll();
    }

    public void saveSub(Subforum subforum){
        SUBREPO.save(subforum);
    }

    public void deleteSub(Long id){
        SUBREPO.deleteById(id);
    }

    public void updateSub(Subforum subforum){
        SUBREPO.save(subforum);
    }

    public Optional<Subforum> findSubById(Long id){
        return SUBREPO.findById(id);
    }

    public Optional<Subforum> findSubByName(String name){
        return SUBREPO.getSubByName(name);
    }
}
