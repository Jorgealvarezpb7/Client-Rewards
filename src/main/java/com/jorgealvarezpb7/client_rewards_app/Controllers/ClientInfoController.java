package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ClientInfoController extends AppNav implements Initializable {

    @FXML private Label nombreCliente;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Authenticated authenticated = Authenticated.getInstance();
        this.nombreCliente.setText((authenticated.getActiveClient().getName()));
    }
    
}
