package com.example.se2Assignment.controller;

import com.example.se2Assignment.model.Movie;
import com.example.se2Assignment.model.Theater;
import com.example.se2Assignment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Set;
import java.security.Principal;
import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService service;
    @Autowired
    private UserService userService;
    @Autowired
    UserDetailsService userDetailsService;
    @GetMapping("/movies")
    public String showMovieList(Model model) {
        List<Movie> listMovies = service.listAll();
        model.addAttribute("listMovies", listMovies);
        return "movies";
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
    @GetMapping("/search")
    public String searchMovieByName(@RequestParam("keyword") String keyword, Model model,Principal principal) {
        List<Movie> movies = service.searchMovieByName(keyword);
        model.addAttribute("movies", movies);
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "search-results";
    }

    @GetMapping("/showAllCategory")
    public String showCategories(Model model,Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        List<String> categories = service.getAllCategories();
        model.addAttribute("categories", categories);

        return "film-category";
    }

    @GetMapping("/showAllCategory/{category}")
    public String showMoviesByCategory(@PathVariable("category") String category, Model model,Principal principal) {
        List<Movie> movies = service.findByGenre(category);
        model.addAttribute("category", category);
        model.addAttribute("movies", movies);
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        return "movie-list"; // Đây là tên của view hiển thị danh sách phim
    }

    @GetMapping("/movie-description/{id}")
    public String showMovieDescription(@PathVariable("id") Long id, Model model,
                                       RedirectAttributes ra, Principal principal) {
        try {
        Movie movie = service.get(id);
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("movie", movie);
            return "movie-description";
        } catch (MovieNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "movie-list";
        }
    }
    @GetMapping("/movie-description/{id}/bookTheater")
    public String bookTicket(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Movie movie = service.get(id);
            Set<Theater> theaters = movie.getTheaters();
            model.addAttribute("theaters", theaters);
             return "theater_list";
        } catch (MovieNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/movies";
        }
    }
    @GetMapping("/movie-description/{id}/bookTheater/userShowTime")
    public String showShowTimeToUser(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        return "showTimePage";
    }

    @GetMapping("/movie-description/{id}/bookTheater/userShowTime/bookSeat")
    public String bookSeatFun(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        return "hello";
    }
}
