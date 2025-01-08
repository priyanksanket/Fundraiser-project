# Community Donation Platform
A comprehensive Java-based Community Donation Platform built with Maven, MySQL database, and designed to run on Apache Tomcat server. The system provides different functionalities for administrators and regular users to manage donations effectively.

🚀 Features
# Admin Features:

Manage Donations (Add/Remove/Update)

Manage Users (Add/Remove/Update)

View all donations and their status

Track donation history

Generate reports

User Features:

View available donation opportunities

Search donations by category, location, or date

View personal donation history

Make donations

# 🛠️ Technical Stack
Java: Core programming language

Maven: Dependency management and build tool

MySQL: Database management

Apache Tomcat: Application server

Eclipse IDE: Development environment

# 📋 Database Schema
Tables:

Users:

id (PRIMARY KEY)

username (UNIQUE)

password

is_admin

Donations:

id (PRIMARY KEY)

category



date

amount

# DonationHistory:

id (PRIMARY KEY)

donation_id (FOREIGN KEY)

user_id (FOREIGN KEY)

donation_date

# 🔧 Setup Instructions
Prerequisites:

Java JDK 17 or higher

Maven 3.x

Eclipse IDE

Apache Tomcat 9.x or higher

# Database Setup:

Database is automatically initialized on first run

Default admin credentials:

Username: root

Password: Abhishek@7581

Project Setup:

Clone the repository:

bash
git clone [repository-url]
Navigate to project directory:

bash
cd community-donation
Build the project:

bash
mvn clean install
Deploy to Tomcat:

Copy the generated WAR file to Tomcat's webapps directory

# 🏗️ Project Structure
Community-Donation-Platform/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── user/
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   ├── UserController.java     # Handles user-related requests
│   │   │   │   │   │   ├── DonationServlet.java    # Handles donation-related requests
│   │   │   │   │   │   ├── LoginServlet.java       # Manages user login
│   │   │   │   │   │   ├── ProfileServlet.java     # Handles user profile functionality
│   │   │   │   │   │   └── RegistrationServlet.java # Manages user registration
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   └── UseDao.java             # Database operations
│   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── User.java               # User entity class
│   │   │   │   │   │   └── Donation.java           # Donation entity class
│   │   │   │   │   ├── service/
│   │   │   │   │   │   └── UserService.java        # Business logic for user management
│   │   ├── resources/
│   │   │   └── application.properties              # Application configurations
│   │   ├── webapp/
│   │   │   ├── HTML/
│   │   │   │   ├── login.html                      # Login page
│   │   │   │   ├── registration.html               # Registration page
│   │   │   │   ├── profile.html                    # Profile page
│   │   │   │   └── donation.html                   # Donation management page
│   │   │   ├── javaScript/
│   │   │   │   ├── login.js                        # Login form logic
│   │   │   │   └── registration.js                 # Registration form logic
│   │   │   └── css/
│   │   │       └── styles.css                      # Styling for the pages
├── test/
│   ├── java/
│   │   └── com/
│   │       └── user/
│   │           └── UseDaoTest.java                 # Unit tests for database operations
├── sql/
│   └── schema.sql                                   # Database schema
├── target/                                          # Compiled files (ignored in .gitignore)
├── .gitignore                                       # Files and folders to ignore in Git
├── pom.xml                                          # Maven build file
├── README.md                                        # Project overview and setup instructions
└── LICENSE                                          # License information (if any)

# 💻 Usage
Admin Login:

Use default admin credentials to access admin panel

Manage donations, users, and view system reports

User Operations:

Register new account

Login with credentials

Browse and search donations

View donation history

# 🔐 Security Features
Password encryption for user accounts

Session management

Role-based access control

Input validation and sanitization

🤝 Contributing
Fork the repository

Create your feature branch:

bash
git checkout -b feature/AmazingFeature
Commit your changes:

bash
git commit -m 'Add some AmazingFeature'
Push to the branch:

bash
git push origin feature/AmazingFeature
Open a Pull Request

# 📝 License
This project is licensed under [appropriate license].

If you need any further assistance or have specific questions about your project, feel free to ask!

