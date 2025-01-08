document.getElementById("loginForm").addEventListener("submit", function(event) {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    
    // Validate email and password
    var passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*(),.?":{}|<>]).{8,}$/;

    if (!email || !password) {
        alert("Please fill out both email and password fields.");
        event.preventDefault(); // Prevent form submission
    } else if (!passwordRegex.test(password)) {
        alert("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one special character.");
        event.preventDefault(); // Prevent form submission
    }
});
