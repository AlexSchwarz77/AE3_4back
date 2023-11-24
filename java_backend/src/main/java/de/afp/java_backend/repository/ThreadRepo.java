package de.afp.java_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.afp.java_backend.model.ThreadModel;

@Repository
public interface ThreadRepo extends JpaRepository<ThreadModel, Long>{
    @Query(value = "Select  thread_id, thread_title, content, thread_model.date, thread_model.subforum_sub_forum_id , user_id FROM thread_model\n" + 
    "INNER JOIN subforum ON thread_model.subforum_sub_forum_id  = subforum.sub_forum_id\n" + 
    "WHERE sub_name = ?1", nativeQuery = true)
    List<ThreadModel> getAllThreadsBySubname(String subName); 
}
