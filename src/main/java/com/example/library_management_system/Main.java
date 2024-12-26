package com.example.library_management_system;

import com.example.library_management_system.utils.DataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file for the login screen
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getResource("/com/example/library_management_system/fxml/login.fxml"))
            );
            Scene scene = new Scene(loader.load());

            // Set the application title and scene
            primaryStage.setTitle("Library Management System | Login Page");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            // Load and set the application icon
            InputStream iconStream = getClass().getResourceAsStream("/com/example/library_management_system/images/library_icon.png");
            if (iconStream != null) {
                primaryStage.getIcons().add(new Image(iconStream));
            } else {
                System.err.println("Warning: Icon not found.");
            }

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Error", "An error occurred while starting the application.");
        }
    }

    /**
     * Displays an error dialog with a given title and message.
     */
    private void showErrorDialog(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
        DataBase.initialize();
    }
}
