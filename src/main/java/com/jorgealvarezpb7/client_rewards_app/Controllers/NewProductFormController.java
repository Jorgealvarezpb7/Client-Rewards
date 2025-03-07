package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewProductFormController extends Authenticated{
    @FXML private TextField productNameField;
    @FXML private TextField productCodeField;
    @FXML private TextField productQuantityField;
    @FXML private TextField productPriceField;

    @FXML protected void handleCreateProduct(ActionEvent event) throws IOException {
        String productName = productNameField.getText();
        String productCode = productCodeField.getText();
        String productQuantity = productQuantityField.getText();
        int productQuantityInt = Integer.parseInt(productQuantity);
        String productPrice = productPriceField.getText();
        int productPriceInt = Integer.parseInt(productPrice);
        this.productService.createProduct(productName, productCode, productQuantityInt, productPriceInt);
        App.setRoot("Views/Inventory/template");
    }
}
