package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewClientFormController extends Authenticated {
    @FXML private TextField clientNameField;

    @FXML protected void handleCreateClient(ActionEvent event) throws IOException {
        String clientName = clientNameField.getText();
        this.clientService.createClient(clientName);
    }
}