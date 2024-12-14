package com.example.covo.doa;
import com.example.covo.model.User;
import com.example.covo.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDAO {
    // Method to add a new user to the database
    public boolean addUser(User user) {
        String query = "INSERT INTO Users (name, email, password, role) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());
            return statement.executeUpdate() > 0; // Returns true if insertion was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to retrieve a user by ID
    public User getUserById(int id) {
        String query = "SELECT * FROM Users WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if user not found
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Method to update user information
    public boolean updateUser(User user) {
        String query = "UPDATE Users SET name = ?, email = ?, password = ?, role = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());
            statement.setInt(5, user.getId());
            return statement.executeUpdate() > 0; // Returns true if update was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a user by ID
    public boolean deleteUser(int id) {
        String query = "DELETE FROM Users WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0; // Returns true if deletion was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to authenticate a user by email and password
    public User authenticate(String email, String password) {
        String query = "SELECT * FROM Users WHERE email = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if authentication fails
    }











}
