<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.movieplatform.Review" %>
<html>
<head>
    <title>All Reviews</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Community Movie Reviews</h2>
    <table class="table table-striped mt-4">
        <thead class="table-dark">
            <tr>
                <th>Movie ID</th>
                <th>User</th>
                <th>Rating</th>
                <th>Review</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Review> list = (List<Review>) request.getAttribute("reviewList");
                if (list != null) {
                    for (Review r : list) {
            %>
            <tr>
                <td><%= r.getMovieId() %></td>
                <td><%= r.getUserId() %></td>
                <td><%= r.getRating() %>/5</td>
                <td><%= r.getReviewText() %></td>
                <td>
                    <% if (r.getReviewType().equals("VERIFIED")) { %>
                        <span class="badge bg-success">Verified Renter</span>
                    <% } else { %>
                        <span class="badge bg-secondary">Guest</span>
                    <% } %>
                </td>
                <td>
                    <a href="../../EditReviewServlet?reviewId=<%= r.getReviewId() %>"
                       class="btn btn-warning btn-sm">Edit</a>
                    <a href="../../DeleteReviewServlet?reviewId=<%= r.getReviewId() %>"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <a href="write.jsp" class="btn btn-primary">Write a Review</a>
</body>
</html>
