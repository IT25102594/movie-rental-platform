package com.movieplatform.models;

public class GuestReview extends Review {
    public GuestReview(String reviewId, String userId, String movieId, int rating, String reviewText, String timestamp) {
        super(reviewId, userId, movieId, rating, reviewText, timestamp);
    }

    @Override
    public String getReviewType() {
        return "GUEST";
    }
}