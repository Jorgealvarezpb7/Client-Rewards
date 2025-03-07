package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.Product;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryController extends Authenticated implements Initializable{
    @FXML private TableView<Product> productsTable;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, String> codeColumn;
    @FXML private TableColumn<Product, Integer> quantityColumn;
    @FXML private TableColumn<Product, Integer> priceColumn;
    @FXML private TableColumn<Product, Integer> created_atColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ArrayList<Product> products = this.productService.listProducts();
        ObservableList<Product> productsObs = FXCollections.observableArrayList(products);

        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("code"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        created_atColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("created_at"));
        productsTable.setItems(productsObs);
    }
}

