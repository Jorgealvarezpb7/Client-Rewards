package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.Product;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.ClockService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class InventoryController extends AppNav implements Initializable {
    private Authenticated authenticated;

    @FXML private TableView<Product> productsTable;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, String> idColumn;
    @FXML private TableColumn<Product, Integer> quantityColumn;
    @FXML private TableColumn<Product, String> priceColumn;
    @FXML private TableColumn<Product, Integer> createdAtColumn;

    @FXML private Label time;
    @FXML private Label date;
    private ClockService clockService;

    public InventoryController() {
        this.authenticated = Authenticated.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ArrayList<Product> products = this.authenticated.productService.listProducts();
        ObservableList<Product> productsObs = FXCollections.observableArrayList(products);

        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("Id"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("priceWithCurrency"));
        createdAtColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("createdAt"));
        productsTable.setItems(productsObs);

        clockService = new ClockService(time, date);
        clockService.start();
    }
}

