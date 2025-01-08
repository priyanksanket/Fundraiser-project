package com.user.service;

import com.user.dao.UseDao;
import com.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UseDao userDao;
    
    public void setUserDao(UseDao userDao) {
    	this.userDao = userDao;
    }

    // Register a new user
    public boolean registerUser(User user) {
        return userDao.insertUser(user);
    }

    // Authenticate user by checking email and password
    public User authenticateUser(String email, String password) {
        // Use the updated verifyUser method to check credentials
        return userDao.verifyUser(email, password);
    }
    
    // Update user details
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}

