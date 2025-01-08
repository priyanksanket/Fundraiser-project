package com.user.model;

import java.sql.Timestamp;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    // Properties corresponding to the 'users' table columns
    private int userId; // Maps to 'user_id'

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email; // Maps to 'email'

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password; // Maps to 'password'

    @NotNull(message = "Name cannot be null")
    private String name; // Maps to 'name'

    @NotNull(message = "Phone number cannot be null")
    private String phone; // Maps to 'phone'

    private String address; // Maps to 'address'

    private Timestamp createdAt; // Maps to 'created_at'

    // Default constructor
    public User() {
    }

    // Parameterized constructor (optional but useful for initialization)
    public User(int userId, String email, String password, String name, String phone, String address, Timestamp createdAt) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

