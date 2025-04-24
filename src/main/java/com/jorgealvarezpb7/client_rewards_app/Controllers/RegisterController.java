package com.jorgealvarezpb7.client_rewards_app.Controllers;

import com.jorgealvarezpb7.client_rewards_app.Models.User;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.App;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController extends AppNav {

    @FXML private TextField newUsernameField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label registerError;

    private final Authenticated authenticated = Authenticated.getInstance();

    @FXML
    protected void handleRegisterButtonAction() throws IOException {
        String username = newUsernameField.getText().trim();
        String password = newPasswordField.getText().trim();
        String confirmPassword = confirmPasswordField.getText().trim();
    
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            registerError.setText("Todos los campos son obligatorios.");
            return;
        }
    
        if (!password.equals(confirmPassword)) {
            registerError.setText("Las contraseñas no coinciden.");
            return;
        }
    
        if (username.equals("admin") || username.equals("user")) {
            registerError.setText("El nombre de usuario son invalidos.");
            return;
        }
    
        boolean success = authenticated.register(username, password);
        if (!success) {
            registerError.setText("Ese nombre de usuario ya está registrado.");
            return;
        }
    
        goToLogin();
    }

}
