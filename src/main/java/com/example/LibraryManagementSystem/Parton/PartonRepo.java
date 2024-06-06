package com.example.LibraryManagementSystem.Parton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PartonRepo extends JpaRepository<Parton,Long> {
    @Query("SELECT p FROM Parton p where p.id=?1")
    Optional<Parton>findPartonById(Long id);

}
