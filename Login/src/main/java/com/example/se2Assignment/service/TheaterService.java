package com.example.se2Assignment.service;

import com.example.se2Assignment.model.Theater;
import com.example.se2Assignment.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository repo;
    public List<Theater> listAll() {
        return (List<Theater>) repo.findAll();
    }
    public void save(Theater theater) {
        repo.save(theater);
    }
    public void delete(Long id) throws TheaterNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new TheaterNotFoundException("Could not find any users with ID " + id);
        }
        repo.deleteById(id);
    }

    public Theater get(Long id) throws TheaterNotFoundException {
        Optional<Theater> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new TheaterNotFoundException("Could not find any users with ID " + id);
    }
}
