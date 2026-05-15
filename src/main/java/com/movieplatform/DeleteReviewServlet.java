package com.movieplatform;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/DeleteReviewServlet")
public class DeleteReviewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reviewIdToDelete = request.getParameter("reviewId");

        // Read all reviews
        List<String> lines = FileHandler.readAllLines("review.txt");

        // Filter out the line that matches the ID
        List<String> updatedLines = lines.stream()
            .filter(line -> !line.startsWith(reviewIdToDelete + " | "))
            .collect(Collectors.toList());

        // Save the updated list back to the file (Overwriting)
        FileHandler.writeAllLines("review.txt", updatedLines);

        // Redirect back to the list
        response.sendRedirect("ViewReviewsServlet");
    }
}

