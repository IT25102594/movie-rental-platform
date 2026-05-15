package com.movieplatform.models;

public abstract class Review {
    // Encapsulation: Private fields
    private String reviewId;
    private String userId;
    private String movieId;
    private int rating;
    private String reviewText;
    private String timestamp;

    public Review(String reviewId, String userId, String movieId, int rating, String reviewText, String timestamp) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.timestamp = timestamp;
    }

    // Abstraction & Polymorphism: Subclasses will provide the specific type
    public abstract String getReviewType();

    // Encapsulation: Public Getters
    public String getReviewId() { return reviewId; }
    public String getUserId() { return userId; }
    public String getMovieId() { return movieId; }
    public int getRating() { return rating; }
    public String getReviewText() { return reviewText; }
    public String getTimestamp() { return timestamp; }

    // Converts object data into a single line for reviews.txt
    public String toFileString() {
        return reviewId + " | " + userId + " | " + movieId + " | " +
                rating + " | " + reviewText + " | " + timestamp + " | " + getReviewType();
    }
}

