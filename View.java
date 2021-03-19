package com.rogovrt;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javax.security.auth.callback.LanguageCallback;

import static javafx.geometry.Pos.*;

public class View extends BorderPane {
    private ButtonBar buttons;
    private HBox content;

    public View() {
        buttons = new ButtonBar();
        content = new HBox(10);
        initContent();
        initButtons();
        setCenter(content);
        setBottom(buttons);
    }

    private void initContent() {
        VBox titles = new VBox(30);
        titles.setPadding(new Insets(20, 0, 0, 20));
        Font labelFont = new Font(16);
        Label nameLabel = new Label("Name : ");
        Label surnameLabel = new Label("Surame : ");
        Label phoneLabel = new Label("Phone : ");
        nameLabel.setFont(labelFont);
        surnameLabel.setFont(labelFont);
        phoneLabel.setFont(labelFont);
        titles.getChildren().addAll(nameLabel, surnameLabel, phoneLabel);
        VBox fields = new VBox(30);
        fields.setPadding(new Insets(20, 0, 0, 20));
        TextField nameField = new TextField();
        TextField surnameField = new TextField();
        TextField phoneField = new TextField();
        fields.getChildren().addAll(nameField, surnameField, phoneField);
        content.getChildren().addAll(titles, fields);
    }

    private void initButtons() {
        Button findButton = new Button("Find");
        findButton.setOnAction(actionEvent -> {
            //String s = Model.requestFromUser(findButton.);
        });
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        buttons.setButtonMinWidth(60);
        buttons.setPadding(new Insets(0, 40, 40, 20));
        buttons.getButtons().addAll(findButton, addButton, deleteButton);
    }
}
