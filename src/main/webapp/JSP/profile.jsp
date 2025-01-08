<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile - Community Donation Platform</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container my-5">
        <div class="card shadow-lg p-4">
            <h3 class="text-center">User Profile</h3>

            <!-- Display Success Message -->
            <c:if test="${not empty successMessage}">
                <div class="alert alert-success">
                    ${successMessage}
                </div>
            </c:if>

            <!-- Display Error Message -->
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">
                    ${errorMessage}
                </div>
            </c:if>

            <form action="profileServlet" method="POST">
                <div class="mb-3">
                    <label class="form-label">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" value="${user.name}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" value="${user.email}" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone:</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Address:</label>
                    <input type="text" class="form-control" id="address" name="address" value="${user.address}" required>
                </div>
                <button type="submit" class="btn btn-success w-100">Update Profile</button>
            </form>
            <a href="logoutServlet" class="btn btn-danger mt-3 w-100">Logout</a>
        </div>
    </div>
</body>
</html>
