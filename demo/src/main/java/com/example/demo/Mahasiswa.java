package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Mahasiswa extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mahasiswacontroller.class.getResource("mahasiswa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setTitle("Mahasiswa");
        mainStage.setScene(scene);
        mainStage.show();


    }
}
