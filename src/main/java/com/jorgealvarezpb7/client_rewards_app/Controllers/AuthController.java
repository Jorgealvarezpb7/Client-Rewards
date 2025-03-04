package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.Database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthController {
    private Database db;

    public AuthController() {
        db = new Database();
    }

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        App.setRoot("primary");
    }
}