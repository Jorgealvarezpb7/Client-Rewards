package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;

import com.jorgealvarezpb7.client_rewards_app.App;

public class AuthController {

    @FXML
    private void logIn() throws IOException {
        App.setRoot("secondary");
    }
}