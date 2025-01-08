<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Make a Donation</title>
</head>
<body>
    <h2>Make a Donation</h2>

    <!-- Display success or error messages -->
    <c:if test="${param.success != null}">
        <p style="color:green;">Donation successful!</p>
    </c:if>
    <c:if test="${param.error != null}">
        <p style="color:red;">There was an error with the donation. Please try again.</p>
    </c:if>

    <!-- Donation Form -->
    <form action="donation" method="post">
        <label for="donationType">Donation Type:</label><br>
        <input type="text" id="donationType" name="donationType" required><br><br>

        <label for="donationAmount">Amount:</label><br>
        <input type="number" id="donationAmount" name="donationAmount" step="0.01" required><br><br>

        <label for="donationDescription">Description:</label><br>
        <textarea id="donationDescription" name="donationDescription" required></textarea><br><br>

        <input type="submit" value="Donate">
    </form>

    <hr>

    <h3>Your Donation History</h3>

    <!-- Display donation history -->
    <c:if test="${not empty donations}">
        <table border="1">
            <thead>
                <tr>
                    <th>Donation Type</th>
                    <th>Amount</th>
                    <th>Description</th>
                    <th>Donation Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="donation" items="${donations}">
                    <tr>
                        <td>${donation.donationType}</td>
                        <td>${donation.donationAmount}</td>
                        <td>${donation.donationDescription}</td>
                        <td>${donation.donatedAt}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty donations}">
        <p>No donations made yet.</p>
    </c:if>

</body>
</html>

