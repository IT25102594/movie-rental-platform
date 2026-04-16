package com.movieplatform;

import com.movieplatform.utils.FileHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/EditReviewServlet")
public class EditReviewServlet extends HttpServlet {
    
    // 1. Load the existing data into the edit form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reviewId = request.getParameter("reviewId");
        List<String> lines = FileHandler.readAllLines("review.txt");
        
        for (String line : lines) {
            if (line.startsWith(reviewId + " | ")) {
                String[] p = line.split(" \\| ");
                request.setAttribute("review", p); // Send the array to the JSP
                break;
            }
        }
        request.getRequestDispatcher("views/review/edit.jsp").forward(request, response);
    }

    // 2. Save the updated data
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reviewId = request.getParameter("reviewId");
        String newRating = request.getParameter("rating");
        String newText = request.getParameter("reviewText");

        List<String> lines = FileHandler.readAllLines("review.txt");
        List<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            if (line.startsWith(reviewId + " | ")) {
                String[] p = line.split(" \\| ");
                // Update rating (p[3]) and text (p[4])
                String updatedLine = p[0] + " | " + p[1] + " | " + p[2] + " | " + newRating + " | " + newText + " | " + p[5] + " | " + p[6];
                updatedLines.add(updatedLine);
            } else {
                updatedLines.add(line);
            }
        }

        FileHandler.writeAllLines("review.txt", updatedLines);
        response.sendRedirect("ViewReviewsServlet");
    }
}
