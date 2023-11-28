package de.afp.java_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.afp.java_backend.model.PostModel;

@Repository
public interface PostRepo extends JpaRepository<PostModel, Long>{
    
    @Query(value = "Select count(post_id) as postCount from post_model where user_id = ?1", nativeQuery=true)
   Long countPostByUser(Long id);

    @Query(value = "Select * FROM post_model WHERE thread_id = ?1", nativeQuery = true)
    List<Optional<PostModel>> findAllPostByThreadId(Long threadId);

    @Query(value = "SELECT * from post_model  where user_id = ?1  order by date desc limit 10", nativeQuery = true)
    List<Optional<PostModel>> lastPostsByUser(Long id);

}
