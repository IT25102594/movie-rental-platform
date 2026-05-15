<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Review</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <% String[] r = (String[]) request.getAttribute("review"); %>
    <h2>Edit Your Review</h2>
    <form action="/EditReviewServlet" method="post" class="mt-4">
        <input type="hidden" name="reviewId" value="<%= r[0] %>">

        <div class="mb-3">
            <label class="form-label">Movie ID:</label>
            <p class="form-control-plaintext"><%= r[2] %></p>
        </div>

        <div class="mb-3">
            <label for="rating" class="form-label">New Rating:</label>
            <input type="number" id="rating" name="rating" class="form-control" value="<%= r[3] %>" min="1" max="5" required>
        </div>

        <div class="mb-3">
            <label for="reviewText" class="form-label">Your Thoughts:</label>
            <textarea id="reviewText" name="reviewText" class="form-control" rows="4" required><%= r[4] %></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Save Changes</button>
        <a href="/ViewReviewsServlet" class="btn btn-secondary">Cancel</a>
    </form>
</body>
</html>

