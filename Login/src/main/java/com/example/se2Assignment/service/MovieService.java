package com.example.se2Assignment.service;

import com.example.se2Assignment.model.Movie;
import com.example.se2Assignment.model.Theater;
import com.example.se2Assignment.repository.MovieRepository;
import com.example.se2Assignment.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repo;
    public List<Movie> listAll() {
        return (List<Movie>) repo.findAll();
    }
    public void save(Movie movie) {
        repo.save(movie);
    }
    public void delete(Long id) throws MovieNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new MovieNotFoundException("Could not find any movies with ID " + id);
        }
        repo.deleteById(id);
    }
    public Movie get(Long id) throws MovieNotFoundException {
        Optional<Movie> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new MovieNotFoundException("Could not find any movies with ID " + id);
    }
    public List<Movie> searchMovieByName(String keyword) {
        return repo.findByMovieNameContainingIgnoreCase(keyword);
    }
    public List<String> getAllCategories() {
        return repo.findAllCategories();
    }
    public List<Movie> findByGenre(String genre) {
        return repo.findByGenre(genre);
    }

}
