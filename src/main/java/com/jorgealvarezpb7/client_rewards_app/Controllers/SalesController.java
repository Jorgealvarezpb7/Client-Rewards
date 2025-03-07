package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.Sale;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalesController extends Authenticated implements Initializable{
    @FXML private TableView<Sale> salesTable;
    @FXML private TableColumn<Sale, String> productColumn;
    @FXML private TableColumn<Sale, Integer> quantityColumn;
    @FXML private TableColumn<Sale, String> clientColumn;
    @FXML private TableColumn<Sale, Integer> total_AmountColumn;
    @FXML private TableColumn<Sale, Integer> created_atColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ArrayList<Sale> sales = this.saleService.listSales();
        ObservableList<Sale> salesObs = FXCollections.observableArrayList(sales);

        productColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("product"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("quantity"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<Sale, String>("client"));
        total_AmountColumn.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("total_Amount"));
        created_atColumn.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("created_at"));
        salesTable.setItems(salesObs);
    }
}
