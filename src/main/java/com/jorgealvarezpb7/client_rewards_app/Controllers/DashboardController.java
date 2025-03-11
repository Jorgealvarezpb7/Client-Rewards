package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.Database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DashboardController extends Authenticated {
    @FXML private TextField userNameField;
    @FXML private PasswordField passwordField;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        String userName = userNameField.getText();
        String password = passwordField.getText();

        App.setRoot("Views/Dashboard/template");
    }
}
