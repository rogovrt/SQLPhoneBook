package com.rogovrt;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.sql.SQLException;

public class View extends BorderPane {
    private final ButtonBar buttons;
    private final HBox content;
    private final TextArea resultOfRequest;
    private TextField nameField;
    private TextField surnameField;
    private TextField phoneField;


    public View() {
        buttons = new ButtonBar();
        content = new HBox(10);

        resultOfRequest = new TextArea();
        resultOfRequest.setEditable(false);
        resultOfRequest.setMinHeight(100);
        resultOfRequest.setMaxHeight(100);
        resultOfRequest.setMinWidth(250);
        resultOfRequest.setMaxWidth(250);
        resultOfRequest.setFont(new Font(14));
        initContent();
        initButtons();

        setTop(content);
        setCenter(resultOfRequest);
        setBottom(buttons);
    }

    private void initContent() {
        VBox titles = new VBox(20);
        titles.setPadding(new Insets(10, 0, 0, 20));
        Font labelFont = new Font(16);
        Label nameLabel = new Label("Name : ");
        Label surnameLabel = new Label("Surname : ");
        Label phoneLabel = new Label("Phone : ");
        nameLabel.setFont(labelFont);
        surnameLabel.setFont(labelFont);
        phoneLabel.setFont(labelFont);
        titles.getChildren().addAll(nameLabel, surnameLabel, phoneLabel);
        VBox fields = new VBox(20);
        fields.setPadding(new Insets(10, 0, 0, 20));
        nameField = new TextField();
        surnameField = new TextField();
        phoneField = new TextField();
        fields.getChildren().addAll(nameField, surnameField, phoneField);
        content.getChildren().addAll(titles, fields);
        nameField.getText();
    }

    private void initButtons() {
        Button findButton = new Button("Find");
        findButton.setOnAction(actionEvent -> actionOnButton(findButton.getText()));
        Button addButton = new Button("Add");
        addButton.setOnAction(actionEvent -> actionOnButton(addButton.getText()));
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(actionEvent -> actionOnButton(deleteButton.getText()));
        buttons.setButtonMinWidth(60);
        buttons.setPadding(new Insets(0, 40, 40, 20));
        buttons.getButtons().addAll(findButton, addButton, deleteButton);
    }

    private void actionOnButton(String buttonName) {
        try {
            String result = Controller.sendUserRequest(buttonName, nameField.getText(), surnameField.getText(), phoneField.getText());
            resultOfRequest.setText(result);
        } catch (SQLException | ClassNotFoundException throwables) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Problems with connection two SQLDatabase!\n");
            alert.showAndWait();
        }
    }
}
