package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Application {

    private Stage primaryStage;
    private TextField usernameField;
    private PasswordField passwordField;
    private Label usernameLabel;
    private Label passwordLabel;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginScene();
    }

    // Method untuk menampilkan scene login
    private void showLoginScene() {
        GridPane loginGridPane = new GridPane();
        loginGridPane.setPadding(new Insets(20, 20, 20, 20));
        loginGridPane.setVgap(10);
        loginGridPane.setHgap(10);

        usernameLabel = new Label("Username:");
        passwordLabel = new Label("Password:");

        usernameField = new TextField();
        passwordField = new PasswordField();

        loginGridPane.add(usernameLabel, 0, 0);
        loginGridPane.add(usernameField, 1, 0);
        loginGridPane.add(passwordLabel, 0, 1);
        loginGridPane.add(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> handleLogin());
        loginGridPane.add(loginButton, 1, 2);

        primaryStage.setScene(new Scene(loginGridPane, 300, 200));
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    // Method untuk menghandle proses login
    private void handleLogin() {
        // Cek apakah username dan password valid
        if ("admin".equals(usernameField.getText()) && "password".equals(passwordField.getText())) {
            // Jika valid, tampilkan scene utama
            showMainScene();
        } else {
            // Jika tidak valid, tampilkan pesan error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login Failed");
            alert.setContentText("Please check your username and password.");
            alert.showAndWait();
        }
    }

    // Method untuk menampilkan scene utama
    private void showMainScene() {
        // Kode untuk menampilkan scene utama (bagian lain dari aplikasi)
    }

    public static void main(String[] args) {
        launch(args);
    }
}