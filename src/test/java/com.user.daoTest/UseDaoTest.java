package com.user.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.user.dao.UseDao;
import com.user.model.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class UseDaoTest {
	
	@Test
    public void testInsertUser() {
        // Arrange: Create a new User object with test data
        User user = new User();
        user.setName("Abhishek Ranjan");
        user.setEmail("abranjan6203@gmail.com");
        user.setPassword("Hello@00");
        user.setPhone("6203434381");
        user.setAddress("Greater Noida");

        // Act: Call insertUser method from UseDao
        UseDao useDao = new UseDao();
        useDao.insertUser(user);
    }   
	
    @Test
    public void testSelectUserByEmail() throws Exception {
        // Set up a real connection to your database for the test
        UseDao useDao = new UseDao();

        // Create a new user object
        User user = new User();
        user.setName("Vishvnath Chauhan");
        user.setEmail("vishv9090@gmail.com");
        user.setPassword("password123");
        user.setPhone("9876543210");
        user.setAddress("Dankaur");

        // Insert the user into the database
        useDao.insertUser(user);

        // Retrieve the user by email
        User retrievedUser = useDao.selectUserByEmail("Vishv9090@gmail.com");

        // Assert that the user was retrieved successfully
        assertNotNull(retrievedUser, "Retrieved user should not be null");
        assertEquals("Vishvnath Chauhan", retrievedUser.getName(), "Names should match");
        assertEquals("9876543210", retrievedUser.getPhone(), "Phone numbers should match");

        // Clean up (delete the test user from the database)
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/DonationSite", "root", "Abhishek@7581")) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE email = ?;");
            preparedStatement.setString(1, "Vishv9090@gmail.com");
            preparedStatement.executeUpdate();
        }
    }

    @Test
    public void testSelectAllUsers() throws Exception {
        UseDao useDao = new UseDao();

        // Retrieve all users
        List<User> users = useDao.selectAllUsers();

        // Assert that the list of users is not null
        assertNotNull(users, "User list should not be null");
    }

    @Test
    public void testUpdateUser() throws Exception {
        UseDao useDao = new UseDao();

        // Create and insert a user
        User user = new User();
        user.setName("Utkarsh");
        user.setEmail("update.test@example.com");
        user.setPassword("password123");
        user.setPhone("9085452312");
        user.setAddress("Test Address");
        useDao.insertUser(user);

        // Retrieve the inserted user
        User existingUser = useDao.selectUserByEmail("update.test@example.com");
        assertNotNull(existingUser, "Existing user should not be null");

        // Update the user's details
        existingUser.setName("Anant Kumar Tiwari");
        existingUser.setPhone("1234567890");
        existingUser.setAddress("Pari Chawk");

        boolean updateResult = useDao.updateUser(existingUser);
        assertTrue(updateResult, "Update should return true");

        // Retrieve the updated user
        User updatedUser = useDao.selectUserByEmail("update.test@example.com");
        assertEquals("Anant Kumar Tiwari", updatedUser.getName(), "Updated name should match");
        assertEquals("1234567890", updatedUser.getPhone(), "Updated phone should match");
        assertEquals("Pari Chawk", updatedUser.getAddress(), "Updated address should match");

        // Clean up (delete the test user from the database)
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/DonationSite", "root", "Abhishek@7581")) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE email = ?;");
            preparedStatement.setString(1, "update.test@example.com");
            preparedStatement.executeUpdate();
        }
    }

    @Test
    public void testVerifyUser() throws Exception {
        UseDao useDao = new UseDao();

        // Create and insert a user
        User user = new User();
        user.setName("Verify User");
        user.setEmail("verify.user@example.com");
        user.setPassword("password123");
        user.setPhone("4444444444");
        user.setAddress("Verify Address");
        useDao.insertUser(user);

        // Verify user credentials
        User verifiedUser = useDao.verifyUser("verify.user@example.com", "password123");

        assertNotNull(verifiedUser, "Verified user should not be null");
        assertEquals("Verify User", verifiedUser.getName(), "Verified user name should match");

        // Clean up (delete the test user from the database)
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/DonationSite", "root", "Abhishek@7581")) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE email = ?;");
            preparedStatement.setString(1, "verify.user@example.com");
            preparedStatement.executeUpdate();
        }
    }
    
}



