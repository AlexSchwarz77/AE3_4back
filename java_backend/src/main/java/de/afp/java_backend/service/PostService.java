package de.afp.java_backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.afp.java_backend.model.PostModel;
import de.afp.java_backend.repository.PostRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostService {
    private final PostRepo POSTREPO;

   
    public PostService(PostRepo POSTREPO){
        this.POSTREPO = POSTREPO;
    }

    public List<PostModel> allPost(){
        return POSTREPO.findAll();
    }

    public void savePost(PostModel post){

        post.setDate(LocalDateTime.now());
        POSTREPO.save(post);
    }

    public void deletePost(Long id){
        POSTREPO.deleteById(id);
    }

    public void updatePost(PostModel post){
        POSTREPO.save(post);
    }

    public Optional<PostModel> findPostById(Long id){
        return POSTREPO.findById(id);
    }

    public Long countPostByUser(Long id){
        return POSTREPO.countPostByUser(id);
    }

    public List<Optional<PostModel>> findPostByThreadId(Long threadId){
        return POSTREPO.findAllPostByThreadId(threadId);
    }

    public List<Optional<PostModel>> latestPostsByUser(Long id){
        return POSTREPO.lastPostsByUser(id);
    }
}
