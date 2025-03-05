package com.jorgealvarezpb7.client_rewards_app.Services;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Authenticated {
    protected Database db;

    public Authenticated() {
        db = new Database();
    }

    @FXML protected void goToClients(ActionEvent event) throws IOException {
        App.setRoot("Views/Clients/template");
    }

    @FXML protected void goToDashboard(ActionEvent event) throws IOException {
        App.setRoot("Views/Dashboard/template");
    }
}
