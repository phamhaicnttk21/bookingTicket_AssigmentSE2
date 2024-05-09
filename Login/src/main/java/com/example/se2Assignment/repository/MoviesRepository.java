package com.example.se2Assignment.repository;

import com.example.se2Assignment.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository  extends JpaRepository<Movies,Long> {
    public Long countById(Long id);
}
