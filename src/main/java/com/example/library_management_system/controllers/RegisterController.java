package com.example.library_management_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegisterController {

    public void goToLoginPage(ActionEvent event) throws Exception{
        try {
            // Load the Register page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/library_management_system/fxml/login.fxml"));
            Parent root = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Page");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
