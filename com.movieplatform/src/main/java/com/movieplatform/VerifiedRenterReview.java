package com.movieplatform.models;

public class VerifiedRenterReview extends Review {
    public VerifiedRenterReview(String reviewId, String userId, String movieId, int rating, String reviewText, String timestamp) {
        super(reviewId, userId, movieId, rating, reviewText, timestamp);
    }

    @Override
    public String getReviewType() {
        return "VERIFIED";
    }
}