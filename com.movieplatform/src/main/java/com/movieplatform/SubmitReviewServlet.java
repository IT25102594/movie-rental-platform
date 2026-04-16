package com.movieplatform.servlets;

import com.movieplatform.utils.FileHandler;
import com.movieplatform.models.Review;
import com.movieplatform.models.VerifiedRenterReview;
import com.movieplatform.models.GuestReview;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/SubmitReviewServlet")
public class SubmitReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Get data from the form
        String movieId = request.getParameter("movieId");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String reviewText = request.getParameter("reviewText");

        // 2. Get the logged-in User ID from the Session
        HttpSession session = request.getSession();
        String userId = "U001"; // Hardcoded for testing

        // 3. Logic: Is the user a verified renter?
        boolean hasRented = false;
        List<String> rentals = FileHandler.readAllLines("rentals.txt");
        for (String line : rentals) {
            String[] parts = line.split(" \\| ");
            // Check if userId AND movieId match a record in rentals.txt
            if (parts[1].equals(userId) && parts[2].equals(movieId)) {
                hasRented = true;
                break;
            }
        }

        // 4. Create the correct Review object (Polymorphism)
        String reviewId = FileHandler.generateId("review.txt", "RV");
        String timestamp = LocalDateTime.now().toString();
        Review newReview;

        if (hasRented) {
            newReview = new VerifiedRenterReview(reviewId, userId, movieId, rating, reviewText, timestamp);
        } else {
            newReview = new GuestReview(reviewId, userId, movieId, rating, reviewText, timestamp);
        }

        // 5. Save to file using FileHandler
        FileHandler.appendLine("review.txt", newReview.toFileString());

        // 6. Redirect back to view reviews
        response.sendRedirect("views/review/viewreviews.jsp?status=success");
    }
}