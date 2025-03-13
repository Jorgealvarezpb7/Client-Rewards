package com.jorgealvarezpb7.client_rewards_app.Services;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AppNav {
    
    @FXML
    public void goToClients(ActionEvent event) throws IOException {
        App.setRoot("Views/Clients/template");
    }

    @FXML
    public void goToDashboard(ActionEvent event) throws IOException {
        App.setRoot("Views/Dashboard/template");
    }

    @FXML
    public void goToInventory(ActionEvent event) throws IOException {
        App.setRoot("Views/Inventory/template");
    }

    @FXML
    public void goToSales(ActionEvent event) throws IOException {
        App.setRoot("Views/Sales/template");
    }

    @FXML
    public void goToClientInfo(ActionEvent event) throws IOException {
        App.setRoot("Views/ClientInfo/template");
    }

    @FXML
    protected void goToNewClientForm(ActionEvent event) throws IOException {
        App.setRoot("Views/NewClientForm/template");
    }

    @FXML
    protected void goToNewProductForm(ActionEvent event) throws IOException {
        App.setRoot("Views/NewProductForm/template");
    }

    @FXML
    public void goToNewSaleForm(ActionEvent event) throws IOException {
        App.setRoot("Views/NewSaleForm/template");
    }

    @FXML
    public void signOut(ActionEvent event) throws IOException {
        App.setRoot("Views/Auth/template");
    }
}
