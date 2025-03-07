package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewClientFormController extends Authenticated {
    @FXML private TextField clientNameField;
    @FXML private TextField clientSurnameField;
    @FXML private TextField clientPhoneField;
    @FXML private TextField clientEmailField;

    @FXML protected void handleCreateClient(ActionEvent event) throws IOException {
        String clientName = clientNameField.getText();
        String clientSurname = clientSurnameField.getText();
        String clientPhone = clientPhoneField.getText();
        String clientEmail = clientEmailField.getText();
        this.clientService.createClient(clientName, clientSurname, clientPhone, clientEmail);
        App.setRoot("Views/Clients/template");
    }
}