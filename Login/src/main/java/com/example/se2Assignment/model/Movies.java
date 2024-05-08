package com.example.se2Assignment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String movieName;
    private String theaterName;
    private String genre;
    private String cast;
    private String duration;

    private String rate;
    private String posterUrl;
    private String description;
    public Movies(String movieName, String theaterName,String genre, String cast, String duration,
                   String rate, String posterUrl, String description) {
        this.movieName = movieName;
        this.theaterName =theaterName;
        this.genre = genre;
        this.cast = cast;
        this.duration = duration;
        this.rate = rate;
        this.posterUrl = posterUrl;
        this.description = description;
    }
    public long getId() {
        return id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }




    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
