package com.movieplatform;

import com.movieplatform.utils.FileHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ViewReviewsServlet")
public class ViewReviewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Review> allReviews = new ArrayList<>();
        List<String> lines = FileHandler.readAllLines("review.txt");

        for (String line : lines) {
            String[] p = line.split(" \\| ");
            // p[0]=ID, p[1]=User, p[2]=Movie, p[3]=Rating, p[4]=Text, p[5]=Time, p[6]=Type
            
            Review review;
            if (p[6].equals("VERIFIED")) {
                review = new VerifiedRenterReview(p[0], p[1], p[2], Integer.parseInt(p[3]), p[4], p[5]);
            } else {
                review = new GuestReview(p[0], p[1], p[2], Integer.parseInt(p[3]), p[4], p[5]);
            }
            allReviews.add(review);
        }

        // Send the list to the JSP page
        request.setAttribute("reviewList", allReviews);
        request.getRequestDispatcher("views/review/viewreviews.jsp").forward(request, response);
    }
}
