<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Donate Now</title>
</head>
<body>
    <h1>Make a Donation</h1>
    <form action="donation" method="post">
        <label for="donationType">Donation Type:</label>
        <select name="donationType" id="donationType" required>
            <option value="Food">Food</option>
            <option value="Money">Money</option>
            <option value="Stationery">Stationery</option>
            <option value="Gadgets">Gadgets</option>
        </select>
        <br><br>
        <label for="donationAmount">Amount/Quantity:</label>
        <input type="number" name="donationAmount" id="donationAmount" required>
        <br><br>
        <label for="donationDescription">Description:</label>
        <textarea name="donationDescription" id="donationDescription" rows="4" required></textarea>
        <br><br>
        <button type="submit">Donate</button>
    </form>
</body>
</html>
