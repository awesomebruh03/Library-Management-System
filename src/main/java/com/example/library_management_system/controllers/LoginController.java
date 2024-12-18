package com.example.library_management_system.controllers;

import com.example.library_management_system.utils.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

public class LoginController {

    public TextField loginEmail;
    public PasswordField loginPassword;
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

    //from login page to register page
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

    //from login page to dashboard page
    public void goToLandingPage(ActionEvent event) throws Exception {
        try {

            // to special character check
            String pattern = ".*[A-Z].*.*[a-z].*.*[!@#$%^&*(),.?\":{}|<>].*";

            // get the value of email and password
            String email = loginEmail.getText();
            String password = loginPassword.getText();

            Connection connection = DataBase.getConnection();

            boolean validUser = DataBase.validUser("asif", "a@gmail.com");

            if(validUser){
                System.out.println("User find");
            }
            else {
                System.out.println("Not find");
            }

            if(email == null || email.isEmpty() || password == null || password.isEmpty()){
                Alert nullEmailPassAlert = new Alert(Alert.AlertType.ERROR);
                nullEmailPassAlert.setTitle("Login Error");
                nullEmailPassAlert.setHeaderText("Enter Email and Password to Login");

                // change the alert box size
                DialogPane dialogPane = nullEmailPassAlert.getDialogPane();
                dialogPane.setPrefSize(600,300);
                nullEmailPassAlert.showAndWait();
            }

            else if(email.contains("@") && password.length()>=6 && password.matches(pattern)){
                // Load the Register page FXML file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/library_management_system/fxml/dashboard.fxml"));
                Parent root = loader.load();

                // Get the current stage and set the new scene
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Dashboard");
                stage.show();

                Alert loginSuccessfulAlert = new Alert(Alert.AlertType.INFORMATION);
                loginSuccessfulAlert.setTitle("Login Successful");
                loginSuccessfulAlert.setHeaderText("Successfully logged in");

                DialogPane dialogPane = loginSuccessfulAlert.getDialogPane();
                dialogPane.setPrefSize(600,300);
                loginSuccessfulAlert.showAndWait();
            }
            else{
                if(!email.contains("@")){
                    System.out.println("Error : Email must contain @ .");
                    // show an alert if the email does not contain @ sign
                    Alert emailAlert = new Alert(Alert.AlertType.ERROR);
                    emailAlert.setTitle("Login Error");
                    emailAlert.setHeaderText("Email must contain @");

                    DialogPane dialogPane = emailAlert.getDialogPane();
                    dialogPane.setPrefSize(600,300);
                    emailAlert.showAndWait();
                }
                else if(password.length()<6){
                    System.out.println("Error: Password must be 6 characters.");
                    // show an alert if the length of password is less than 6
                    Alert passwordLengthAlert = new Alert(Alert.AlertType.ERROR);
                    passwordLengthAlert.setTitle("Login Error");
                    passwordLengthAlert.setHeaderText("Password length must be 6 character");

                    DialogPane dialogPane = passwordLengthAlert.getDialogPane();
                    dialogPane.setPrefSize(600,300);
                    passwordLengthAlert.showAndWait();
                }
                else if(!password.contains(pattern)){
                    System.out.println("Error: Password must contain at least one special character.");
                    // show an alert if the password does not contain any special character and uppercase and lowercase character
                    Alert passwordPatternAlert = new Alert(Alert.AlertType.ERROR);
                    passwordPatternAlert.setTitle("Login Error");
                    passwordPatternAlert.setHeaderText("Password must contain at least one special character and uppercase and lowercase character");

                    DialogPane dialogPane = passwordPatternAlert.getDialogPane();
                    dialogPane.setPrefSize(600,300);
                    passwordPatternAlert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TextField getLoginEmail(){
        return loginEmail;
    }
    public void setLoginEmail(TextField loginEmail) {
        this.loginEmail = loginEmail;
    }

    public PasswordField getLoginPassword(){
        return loginPassword;
    }
    public void  setLoginPassword(PasswordField loginPassword){
        this.loginPassword = loginPassword;
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