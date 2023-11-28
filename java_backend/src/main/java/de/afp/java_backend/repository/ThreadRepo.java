package de.afp.java_backend.repository;

import java.util.List;
import java.util.Optional;

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

    @Query(value = "select count(thread_id) as threadCount from thread_model where user_id = ?1", nativeQuery = true)
    Long countThreadsByUser(Long id);

    @Query(value = "SELECT * from thread_model  where user_id = ?1  order by date desc limit 10", nativeQuery = true)
    List<Optional<ThreadModel>> lastThreadsByUser(Long id);
}
