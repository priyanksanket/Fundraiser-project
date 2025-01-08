package com.user.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import com.user.dao.UseDao;
import com.user.model.User;
import com.user.service.UserService;
import org.junit.jupiter.api.Test;


public class UserServiceTest {


    // Test for user registration success
    @Test
    public void testRegisterUserSuccess() {
        // Create a User object with unique data to avoid conflicts with existing data
        User user = new User();
        user.setName("Alice Smith");
        user.setEmail("alice.smith" + System.currentTimeMillis() + "@example.com");  // Unique email with timestamp
        user.setPassword("securePassword123");
        user.setPhone("9876543210");
        user.setAddress("456 Oak Street");

        // Create an instance of UseDao (considering using real database for testing)
        UseDao userDao = new UseDao(); 

        // Create an instance of UserService
        UserService userService = new UserService();
        userService.setUserDao(userDao);  // Set the UseDao manually

        // Simulate user registration
        boolean result = userService.registerUser(user);

        // Assert that the registration returns true (indicating success)
        assertTrue(result, "User should be successfully registered.");
    }


    // Test for registration failure due to duplicate email
    @Test
    public void testRegisterUserFailureDueToDuplicateEmail() {
        // Assume a user with this email already exists in the database
        User user = new User();
        user.setName("Jane");
        user.setEmail("john.doe@example.com");  // Same email as in the DB
        user.setPassword("password123");
        user.setPhone("0987654321");
        user.setAddress("456 St");

        UseDao userDao = new UseDao();  // Using real DAO here for actual checking
        UserService userService = new UserService();
        userService.setUserDao(userDao);  // Manually inject UseDao

        // Simulate user registration, which should fail due to duplicate email
        boolean result = userService.registerUser(user);

        // Assert that the registration returns false (indicating failure)
        assertFalse(result, "User registration should fail due to duplicate email.");
    }

    // Test for user update failure (non-existent user)
    @Test
    public void testUpdateUserFailure() {
        // Create a User object with invalid data (e.g., non-existent user ID)
        User user = new User();
        user.setUserId(999);  // Assuming user with ID 999 doesn't exist in DB
        user.setName("Invalid User");
        user.setEmail("invalid.user@example.com");
        user.setPhone("0000000000");
        user.setAddress("Unknown St");

        UseDao userDao = new UseDao();  // Using real DAO to simulate the failure
        UserService userService = new UserService();
        userService.setUserDao(userDao);  // Manually inject UseDao

        // Simulate the update operation, which should fail due to non-existent user
        boolean result = userService.updateUser(user);

        // Assert that the update operation failed
        assertFalse(result, "User details should not be updated due to non-existent user.");
    }
}


