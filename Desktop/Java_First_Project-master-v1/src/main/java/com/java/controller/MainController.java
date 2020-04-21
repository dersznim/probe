package com.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label label;

    @FXML
    private Button buttonHello;

    @FXML
    private Button buttonClear;

    @FXML
    void buttonClearOnAction(ActionEvent event) {
        label.setText("Clear");

    }

    @FXML
    void buttonHelloOnAction(ActionEvent event) {
        label.setText("Hello");

    }

}