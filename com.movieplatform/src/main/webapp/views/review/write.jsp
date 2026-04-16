<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Write a Review</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2>Submit a Movie Review</h2>
<form action="../../SubmitReviewServlet" method="post" class="mt-4">
    <div class="mb-3">
        <label class="form-label">Movie ID</label>
        <input type="text" name="movieId" class="form-control" placeholder="e.g., M001" required>
    </div>

    <div class="mb-3">
        <label class="form-label">Rating (1 to 5)</label>
        <select name="rating" class="form-select">
            <option value="1">1 - Poor</option>
            <option value="2">2 - Fair</option>
            <option value="3">3 - Good</option>
            <option value="4">4 - Very Good</option>
            <option value="5">5 - Excellent</option>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">Your Review</label>
        <textarea name="reviewText" class="form-control" rows="4" required></textarea>
    </div>

    <button type="submit" class="btn btn-primary">Submit Review</button>
</form>
</body>
</html>

