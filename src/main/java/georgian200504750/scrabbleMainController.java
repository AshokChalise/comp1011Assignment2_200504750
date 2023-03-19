package com.example.scrabble;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class scrabbleMainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}