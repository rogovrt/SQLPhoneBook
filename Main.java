package com.rogovrt;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.engine.Mode;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
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
        /*Model m = new Model();
        try {

            System.out.println(m.requestFromUser("Find", "Lev", null, null));
            System.out.println(m.requestFromUser("Find", null, "Pushkin", null));
            System.out.println(m.requestFromUser("Find", null, null, "342"));

            //System.out.println(m.requestFromUser("Add", "Test", "Testovich", "+78009855555"));
            System.out.println(m.requestFromUser("Find", null, null, "+78009855555"));
            System.out.println(m.requestFromUser("Delete", "Test", "Testovich", null));
            System.out.println(m.requestFromUser("Find", null, null, "+78009855555"));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }*/

    }
}

