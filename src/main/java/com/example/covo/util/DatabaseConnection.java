package com.example.covo.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/carpooling";
    private static final String USER = "root";  // Change this to your MySQL username if necessary
    private static final String PASSWORD = "15971597";  // Your MySQL password

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }

        // Establish and return the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to close the connection (optional, you can call this after usage)
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
