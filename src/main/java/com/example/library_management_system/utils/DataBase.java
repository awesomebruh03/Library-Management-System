package com.example.library_management_system.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static final String DB_URL = "jdbc:sqlite:library_management_system.db";
    private static SessionFactory sessionFactory;

    public static void initialize() {
        try {
            System.out.println("Initializing database...");

            // Check if the database file exists
            File dbFile = new File("library_management_system.db");
            if (!dbFile.exists()) {
                // Create a new database file
                try (Connection conn = DriverManager.getConnection(DB_URL)) {
                    if (conn != null) {
                        System.out.println("A new database has been created.");
                    }
                } catch (SQLException e) {
                    System.err.println("Error creating database: " + e.getMessage());
                }
            } else {
                System.out.println("Database already exists.");
            }

            // Configure Hibernate
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("Hibernate configured successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}