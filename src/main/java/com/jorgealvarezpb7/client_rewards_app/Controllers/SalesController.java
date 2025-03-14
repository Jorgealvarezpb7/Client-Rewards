package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.Sale;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalesController extends AppNav implements Initializable{
    private Authenticated authenticated;

    @FXML private TableView<Sale> salesTable;
    @FXML private TableColumn<Sale, String> productIdColumn;
    @FXML private TableColumn<Sale, Integer> quantityColumn;
    @FXML private TableColumn<Sale, String> clientIdColumn;
    @FXML private TableColumn<Sale, Double> totalAmountColumn;
    @FXML private TableColumn<Sale, Double> pointsColumn;
    @FXML private TableColumn<Sale, Integer> createdAtColumn;

    public SalesController() {
        this.authenticated = Authenticated.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ArrayList<Sale> sales = this.authenticated.saleService.listSales();
        ObservableList<Sale> salesObs = FXCollections.observableArrayList(sales);

        productIdColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("productId"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("quantity"));
        clientIdColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("clientId"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<Sale, Double>("totalAmount"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<Sale, Double>("points"));
        createdAtColumn.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("createdAt"));
        salesTable.setItems(salesObs);
    }
}
