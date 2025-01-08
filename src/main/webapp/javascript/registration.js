document.getElementById("registrationForm").addEventListener("submit", function(event) {
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    // Validate name
    if (!name) {
        alert("Please enter your name.");
        event.preventDefault(); // Prevent form submission
        return;
    }

    // Validate email
    if (!email) {
        alert("Please enter a valid email.");
        event.preventDefault();
        return;
    }

    // Validate password
    if (!password) {
        alert("Please enter a password.");
        event.preventDefault();
        return;
    }

    // Validate password confirmation
    if (password !== confirmPassword) {
        alert("Passwords do not match.");
        event.preventDefault();
        return;
    }
});

