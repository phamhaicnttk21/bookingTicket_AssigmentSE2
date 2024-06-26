package com.example.se2Assignment.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "showtime")
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime showDateTime;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
    // Default constructor
    public ShowTime() {}
    // Parameterized constructor
    public ShowTime(LocalDateTime showDateTime, Movie movie, Theater theater) {
        this.showDateTime = showDateTime;
        this.movie = movie;
        this.theater = theater;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getShowDateTime() {
        return showDateTime;
    }

    public void setShowDateTime(LocalDateTime showDateTime) {
        this.showDateTime = showDateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
