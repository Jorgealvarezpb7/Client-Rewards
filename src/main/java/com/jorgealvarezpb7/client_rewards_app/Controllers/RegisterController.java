package com.jorgealvarezpb7.client_rewards_app.Controllers;

import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;

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

    if (username.length() < 4) {
        registerError.setText("El nombre de usuario debe tener al menos 4 caracteres.");
        return;
    }

    if (password.length() < 6) {
        registerError.setText("La contraseña debe tener al menos 6 caracteres.");
        return;
    }

    if (!username.matches("^[a-zA-Z0-9_]+$")) {
        registerError.setText("El nombre de usuario solo puede contener letras, números y guiones bajos.");
        return;
    }

    if (!password.equals(confirmPassword)) {
        registerError.setText("Las contraseñas no coinciden.");
        return;
    }

    if (username.equalsIgnoreCase("admin") || username.equalsIgnoreCase("user")) {
        registerError.setText("El nombre de usuario ya está en uso.");
        return;
    }

    boolean registrado = authenticated.register(username, password);
    if (!registrado) {
        registerError.setText("No se pudo registrar el usuario. Intenta con otro nombre.");
        return;
    }

    goToLogin();
}

}
