package com.example.se2Assignment.repository;

import com.example.se2Assignment.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Long countById(Long id);
}
