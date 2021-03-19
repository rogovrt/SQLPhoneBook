package com.rogovrt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) {
        View view = new View();
        Scene scene = new Scene(view, 300, 350);
        primaryStage.setMinHeight(350);
        primaryStage.setMaxHeight(350);
        primaryStage.setMinWidth(300);
        primaryStage.setMaxWidth(300);
        primaryStage.setTitle("Phone Book");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

