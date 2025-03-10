package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewProductFormController extends Authenticated{
    @FXML private TextField productNameField;
    @FXML private TextField productIdField;
    @FXML private TextField productQuantityField;
    @FXML private TextField productPriceField;

    @FXML protected void handleCreateProduct(ActionEvent event) throws IOException {
        String productName = productNameField.getText();
        String productId = productIdField.getText();
        String productQuantity = productQuantityField.getText();
        int productQuantityInt = Integer.parseInt(productQuantity);
        String productPrice = productPriceField.getText();
        Double productPriceDouble = Double.parseDouble(productPrice);
        this.productService.createProduct(productName, productId, productQuantityInt, productPriceDouble);
        App.setRoot("Views/Inventory/template");
    }
}
