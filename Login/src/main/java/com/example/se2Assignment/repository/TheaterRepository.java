package com.example.se2Assignment.repository;

import com.example.se2Assignment.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    public Long countById(Long id);
=======

public interface TheaterRepository extends JpaRepository<Theater,Long> {

>>>>>>> c404564894988d53a4d5c4a5a2e557aaa81e7363
}
