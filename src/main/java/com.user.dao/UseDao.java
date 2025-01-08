package com.user.dao;

import com.user.model.User;
import com.user.model.Donation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UseDao {

    // Database connection details
    private String jdbcURL = "jdbc:mysql://localhost:3306/DonationSite"; 
    private String jdbcUsername = "root"; 
    private String jdbcPassword = "Abhishek@7581";

    // SQL Queries for Users
    private static final String INSERT_USER_SQL = 
        "INSERT INTO users (name, email, password, phone, address) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_EMAIL = 
        "SELECT * FROM users WHERE email = ?;";
    private static final String SELECT_USER_BY_ID = 
        "SELECT * FROM users WHERE user_id = ?;";
    private static final String SELECT_ALL_USERS = 
        "SELECT * FROM users;";
    private static final String UPDATE_USERS_SQL = 
        "UPDATE users SET name = ?, phone = ?, address = ? WHERE user_id = ?;";
    private static final String SELECT_USER_BY_EMAIL_PASSWORD = 
        "SELECT * FROM users WHERE email = ? AND password = ?;";
    private static final String SELECT_USER_COUNT_BY_EMAIL =
        "SELECT COUNT(*) FROM users WHERE email = ?;";

    // SQL Queries for Donations
    private static final String INSERT_DONATION_SQL = 
        "INSERT INTO donations (user_id, donation_type, donation_amount, donation_description, donated_at) VALUES (?, ?, ?, ?, NOW());";
    private static final String SELECT_DONATIONS_BY_USER_SQL = 
        "SELECT * FROM donations WHERE user_id = ? ORDER BY donated_at DESC;";

    // Default constructor
    public UseDao() {
        super();
    }

    // Method to establish a database connection
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // User-related methods
    public boolean insertUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User selectUserByEmail(String email) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {

            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean updateUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setInt(4, user.getUserId());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User verifyUser(String email, String password) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_PASSWORD)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Donation-related methods
    public boolean insertDonation(Donation donation) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DONATION_SQL)) {

            preparedStatement.setInt(1, donation.getUserId());
            preparedStatement.setString(2, donation.getDonationType());
            preparedStatement.setDouble(3, donation.getDonationAmount());
            preparedStatement.setString(4, donation.getDonationDescription());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Donation> getDonationsByUser(int userId) {
        List<Donation> donations = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DONATIONS_BY_USER_SQL)) {

            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Donation donation = new Donation();
                donation.setDonationId(rs.getInt("donation_id"));
                donation.setUserId(rs.getInt("user_id"));
                donation.setDonationType(rs.getString("donation_type"));
                donation.setDonationAmount(rs.getDouble("donation_amount"));
                donation.setDonationDescription(rs.getString("donation_description"));
                donations.add(donation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donations;
    }
}
