package de.afp.java_backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.afp.java_backend.model.ThreadHelper;
import de.afp.java_backend.model.ThreadModel;
import de.afp.java_backend.repository.ThreadRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ThreadService {
    public final ThreadRepo THREADREPO;


    public ThreadService(ThreadRepo THREADREPO){
        this.THREADREPO = THREADREPO;
    }

    public List<ThreadModel> allThread(){
        return THREADREPO.findAll();
    }

    public void saveThread(ThreadModel thread){ LocalDateTime x= LocalDateTime.now();
        thread.setDate(x); 
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

    public List<ThreadHelper> getAllThreadsBySubname(String subname){
        List<ThreadModel> sub = THREADREPO.getAllThreadsBySubname(subname);
        List<ThreadHelper> thl =  new ArrayList<>();
        
        for (ThreadModel threadModel : sub) {
            ThreadHelper th = new ThreadHelper();
            th.setContent(threadModel.getContent());
            th.setSubTitle(threadModel.getThreadTitle());
            th.setDate(threadModel.getDate());
            th.setThreadId(threadModel.getThreadId());
            thl.add(th);
        }

        return thl;
    }

    public Long countThreadsByUser(Long id){
        return THREADREPO.countThreadsByUser(id);
    }
    public List<Optional<ThreadModel>> latestThreadsByUser(Long id){
        return THREADREPO.lastThreadsByUser(id);
    }

    public List<Optional<ThreadModel>> latestThreads(){
        return THREADREPO.latestThreads();
    }
}
