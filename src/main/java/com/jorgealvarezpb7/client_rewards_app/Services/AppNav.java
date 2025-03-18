package com.jorgealvarezpb7.client_rewards_app.Services;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class AppNav {
    
    @FXML
    public void goToClients() throws IOException {
        App.setRoot("Views/Clients/template");
    }

    @FXML
    public void goToDashboard() throws IOException {
        App.setRoot("Views/Dashboard/template");
    }

    @FXML
    public void goToInventory() throws IOException {
        App.setRoot("Views/Inventory/template");
    }

    @FXML
    public void goToSales() throws IOException {
        App.setRoot("Views/Sales/template");
    }

    @FXML
    public void goToClientInfo() throws IOException {
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
    public void goToNewSaleForm() throws IOException {
        App.setRoot("Views/NewSaleForm/template");
    }

    @FXML
    public void signOut() throws IOException {
        App.setRoot("Views/Auth/template");
    }
}
