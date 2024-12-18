package com.example.library_management_system.utils;

import java.sql.*;

public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/library_management_system"; // Change as needed
    private static final String USER = "root"; // Replace with your database username
    private static final String PASSWORD = ""; // Replace with your database password

    // Method to establish a database connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

    // Method to fetch all books
    public static void fetchAllBooks() {
        Connection connection = getConnection(); // Establish connection

        if (connection != null) {
            String query = "SELECT * FROM books";

            // Create a Statement and Execute the Query
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                // Print all book information
                System.out.println("BookID | BookName | BookAuthor | BookDept");
                while (resultSet.next()) {
                    int bookID = resultSet.getInt("BookID");
                    String bookName = resultSet.getString("BookName");
                    String bookAuthor = resultSet.getString("BookAuthor");
                    String bookDept = resultSet.getString("BookDept");

                    System.out.printf("%d | %s | %s | %s%n", bookID, bookName, bookAuthor, bookDept);
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            } finally {
                // Close the connection
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }

    public static boolean validUser(String name, String email){
        Connection connection = getConnection();

        if (connection != null) {
            String query = "SELECT * FROM users WHERE name = ? AND email = ?"; // Adjust table/column names as needed

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name); // Set name parameter
                statement.setString(2, email); // Set email parameter

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) { // If a row exists, the user is valid
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }

        return false;
    }
}
