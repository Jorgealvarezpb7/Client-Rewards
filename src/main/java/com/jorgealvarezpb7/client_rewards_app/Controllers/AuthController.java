package com.jorgealvarezpb7.client_rewards_app.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AuthController {
    @FXML private Text actiontarget;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        actiontarget.setText(username + " " + password);
    }
}