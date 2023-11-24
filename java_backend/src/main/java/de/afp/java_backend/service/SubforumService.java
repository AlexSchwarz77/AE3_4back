package de.afp.java_backend.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.afp.java_backend.model.ThreadHelper;
import de.afp.java_backend.model.Subforum;
import de.afp.java_backend.model.ThreadModel;
import de.afp.java_backend.repository.SubforumRepo;
import de.afp.java_backend.repository.ThreadRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubforumService {
    private final SubforumRepo SUBREPO;
    private final ThreadRepo THREADREPO;

    @Autowired
    public SubforumService(SubforumRepo SUBREPO, ThreadRepo THREADREPO){
        this.SUBREPO = SUBREPO;
        this.THREADREPO = THREADREPO;
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
