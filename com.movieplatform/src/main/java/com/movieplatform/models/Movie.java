package com.movieplatform.models;

public abstract class Movie {

    private String movieId;
    private String title;
    private String genre;
    private String director;
    private String releaseYear;
    private double rentalPrice;
    private int availableCopies;
    private String type;

    public Movie(String movieId, String title, String genre, String director,
                 String releaseYear, double rentalPrice, int availableCopies, String type) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rentalPrice = rentalPrice;
        this.availableCopies = availableCopies;
        this.type = type;
    }

    // Abstract methods — each subclass must implement these
    public abstract String getMovieType();       // returns "NEW_RELEASE" or "CLASSIC"
    public abstract double getRentalPrice();     // each subclass can apply its own pricing logic

    // Getters
    public String getMovieId()        { return movieId; }
    public String getTitle()          { return title; }
    public String getGenre()          { return genre; }
    public String getDirector()       { return director; }
    public String getReleaseYear()    { return releaseYear; }
    public int getAvailableCopies()   { return availableCopies; }
    public String getType()           { return type; }

    // Setters
    public void setTitle(String title)                   { this.title = title; }
    public void setGenre(String genre)                   { this.genre = genre; }
    public void setDirector(String director)             { this.director = director; }
    public void setRentalPrice(double rentalPrice)       { this.rentalPrice = rentalPrice; }
    public void setAvailableCopies(int availableCopies)  { this.availableCopies = availableCopies; }

    // Saves this object as a pipe-separated line — matches movies.txt format exactly
    // Format: movieId|title|genre|director|releaseYear|rentalPrice|availableCopies|type
    public String toFileString() {
        return movieId + "|" + title + "|" + genre + "|" + director + "|" +
                releaseYear + "|" + rentalPrice + "|" + availableCopies + "|" + type;
    }
}