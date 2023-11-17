package de.afp.java_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.afp.java_backend.model.PostModel;

@Repository
public interface PostRepo extends JpaRepository<PostModel, Long>{
    
    @Query(value = "Select user.*, count(post_id) from user inner join post_model on user.user_id = post_model.user_id where user.user_id = ?1", nativeQuery=true)
    Optional<?> countPostByUser(Long id);

}
