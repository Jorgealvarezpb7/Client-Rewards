package com.jorgealvarezpb7.client_rewards_app.Services;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Authenticated {
    protected Database db;
    public ClientService clientService;
    public ProductService productService;

    public Authenticated() {
        db = new Database();
        db.runMigrations();
        clientService = new ClientService();
        productService = new ProductService();
    }

    @FXML
    protected void goToClients(ActionEvent event) throws IOException {
        App.setRoot("Views/Clients/template");
    }

    @FXML
    protected void goToDashboard(ActionEvent event) throws IOException {
        App.setRoot("Views/Dashboard/template");
    }

    @FXML
    protected void goToInventory(ActionEvent event) throws IOException {
        App.setRoot("Views/Inventory/template");
    }

    @FXML
    protected void goToSales(ActionEvent event) throws IOException {
        App.setRoot("Views/Sales/template");
    }

    @FXML
    protected void goToClientInfo(ActionEvent event) throws IOException {
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
    protected void goToNewSaleForm(ActionEvent event) throws IOException {
        App.setRoot("Views/NewSaleForm/template");
    }
}