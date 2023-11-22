package de.afp.java_backend.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.afp.java_backend.model.SubHelper;
import de.afp.java_backend.model.Subforum;
import de.afp.java_backend.model.ThreadModel;
import de.afp.java_backend.repository.SubforumRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubforumService {
    private final SubforumRepo SUBREPO;

    @Autowired
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

    public List<ThreadModel> getAllThreadsBySubname(String subname){
        List<ThreadModel> sub = SUBREPO.getAllThreadsBySubname(subname);
        System.out.println(sub);
        return sub;
    }
}
