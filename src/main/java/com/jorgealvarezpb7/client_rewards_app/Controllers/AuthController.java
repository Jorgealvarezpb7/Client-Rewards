package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthController extends AppNav {
    private Authenticated authenticated;

    public AuthController() {
        authenticated = Authenticated.getInstance();
    }

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        boolean isAuthenticated = this.authenticated.authenticate(username, password);

        if (isAuthenticated) {
            this.goToDashboard();
        } else {
            System.out.println("Not auth");
        }
    }
}