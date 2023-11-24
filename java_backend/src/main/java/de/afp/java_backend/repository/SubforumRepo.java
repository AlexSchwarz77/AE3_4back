package de.afp.java_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import de.afp.java_backend.model.Subforum;

@Repository
public interface SubforumRepo extends JpaRepository<Subforum, Long>{
    @Query(value = "Select * FROM subforum WHERE sub_name = ?1", nativeQuery = true)
    Optional<Subforum> getSubByName(String subName); 
}
