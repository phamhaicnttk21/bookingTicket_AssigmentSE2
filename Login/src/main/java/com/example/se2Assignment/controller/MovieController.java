package com.example.se2Assignment.controller;

import com.example.se2Assignment.model.Movie;
import com.example.se2Assignment.model.Theater;
import com.example.se2Assignment.service.MovieNotFoundException;
import com.example.se2Assignment.service.MovieService;
import com.example.se2Assignment.service.TheaterNotFoundException;
import com.example.se2Assignment.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService service;
    @GetMapping("/movies")
    public String showMovieList(Model model) {
        List<Movie> listMovies = service.listAll();
        model.addAttribute("listMovies", listMovies);
        return "Movies";
    }
    @GetMapping("/movies/new")
    public String showNewForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("pageTitle", "Add New Movie");
        return "movie_form";
    }
    @PostMapping("/movies/save")
    public String saveMovie(Movie movie, RedirectAttributes ra) {
        service.save(movie);
        ra.addFlashAttribute("message", "The movie has been saved successfully.");
        return "redirect:/movies";
    }
    @GetMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The movie ID " + id + " has been deleted.");
        } catch (MovieNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/movies";
    }

    @GetMapping("/movies/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Movie movie = service.get(id);
            model.addAttribute("movie", movie);
            model.addAttribute("pageTitle", "Edit movie (ID: " + id + ")");

            return "movie_form";
        } catch (MovieNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/movies";
        }
    }
}