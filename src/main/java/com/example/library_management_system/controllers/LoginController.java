package com.example.library_management_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button goToRegisterPageButton;

    @FXML
    private Button loginButton;

    private Stage stage;
    private Scene scene;

    public void goToRegisterPage(ActionEvent event) throws IOException {
        // Load the FXML resource
//        URL resource = getClass().getResource("/resources/com/example/library_management_system/fxml/register.fxml");
//        if (resource == null) {
//            throw new IOException("FXML file not found at /fxml/register.fxml");
//        }
//
//        Parent root = FXMLLoader.load(resource);
//
//        // Get the current stage from the event source
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//        // Create a new scene and set it on the stage
//        scene = new Scene(root, 1300, 740);
//        stage.setScene(scene);
//        stage.show();
        try {
            // Load the Register page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/library_management_system/fxml/register.fxml"));
            Parent root = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Register Page");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToLandingPage(ActionEvent event) throws Exception {
        try {
            // Load the Register page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/library_management_system/fxml/dashboard.fxml"));
            Parent root = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement login functionality here (e.g., validate credentials, show success/failure message)
//    public void login(ActionEvent event) {
//        // Retrieve user credentials from TextField and PasswordField
//        String email = emailField.getText();
//        String password = passwordField.getText();
//
//        // Implement validation logic here (e.g., check for empty fields, correct format)
//
//        // If credentials are valid, proceed with login action (e.g., switch to main window)
//        if (isValidCredentials(email, password)) {
//            // Code to switch to main window or perform other login actions
//            System.out.println("Login successful!");
//        } else {
//            // Show an error message or notification to indicate incorrect credentials
//            System.out.println("Login failed. Invalid credentials.");
//        }
//    }

//    private boolean isValidCredentials(String email, String password) {
//        // Implement your validation logic here, e.g., using a database or other authentication methods
//        // This is just a placeholder for now
//        return true; // Assuming valid credentials for demonstration purposes
//    }
}