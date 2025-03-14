package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.Client;
import com.jorgealvarezpb7.client_rewards_app.Models.Product;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClientsController extends AppNav implements Initializable {
    private Authenticated authenticated;

    @FXML private TableView<Client> clientsTable;
    @FXML private TableColumn<Client, String> nameColumn;
    @FXML private TableColumn<Client, String> surnameColumn;
    @FXML private TableColumn<Client, String> surname2Column;
    @FXML private TableColumn<Client, String> phoneColumn;
    @FXML private TableColumn<Client, String> emailColumn;
    @FXML private TableColumn<Client, Integer> createdAtColumn;

    public ClientsController() {
        this.authenticated = Authenticated.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ArrayList<Client> clients = this.authenticated.clientService.listClients();
        ObservableList<Client> clientsObs = FXCollections.observableArrayList(clients);

        nameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("surname"));
        surname2Column.setCellValueFactory(new PropertyValueFactory<Client, String>("surname2"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
        createdAtColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("createdAt"));

        clientsTable.setRowFactory(tv -> {
            TableRow<Client> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 2) {
                    Client c = row.getItem();
                    this.authenticated.setActiveClient(c);

                    try {
                        this.goToClientInfo();
                    } catch (Exception e) {
                        // Spp
                    }
                }
            });

            return row;
        });

        clientsTable.setItems(clientsObs);
    }
}
