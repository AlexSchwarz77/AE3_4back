package de.afp.java_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.afp.java_backend.model.ThreadModel;

@Repository
public interface ThreadRepo extends JpaRepository<ThreadModel, Long>{
    
}
