package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load Scene 1
        Parent scene1 = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene loginScene = new Scene(scene1, 800, 600);

        // Load Scene 2
        Parent scene2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene adminScene = new Scene(scene2, 800, 600);

        // Load Scene 3
        Parent scene3 = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        Scene customerScene = new Scene(scene3, 800, 600);

        // Set scene for initial stage
        primaryStage.setTitle("Cinema Booking System");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
