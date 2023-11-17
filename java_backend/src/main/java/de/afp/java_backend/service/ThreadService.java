package de.afp.java_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.afp.java_backend.model.ThreadModel;
import de.afp.java_backend.repository.ThreadRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ThreadService {
    public final ThreadRepo THREADREPO;

    @Autowired
    public ThreadService(ThreadRepo THREADREPO){
        this.THREADREPO = THREADREPO;
    }

    public List<ThreadModel> allThread(){
        return THREADREPO.findAll();
    }

    public void saveThread(ThreadModel thread){
        THREADREPO.save(thread);
    }

    public void deleteThread(Long id){
        THREADREPO.deleteById(id);
    }

    public void updateThread(ThreadModel thread){
        THREADREPO.save(thread);
    }

    public Optional<ThreadModel> findThreadById(Long id){
        return THREADREPO.findById(id);
    }
}
