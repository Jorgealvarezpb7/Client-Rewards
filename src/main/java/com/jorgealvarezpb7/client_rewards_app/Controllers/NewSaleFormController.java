package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewSaleFormController extends Authenticated{
    @FXML private TextField saleProductIdField;
    @FXML private TextField saleQuantityField;
    @FXML private TextField saleClientIdField;
    @FXML private TextField saleTotalAmountField;

    @FXML protected void handleCreateSale(ActionEvent event) throws IOException {
        String saleProductId = saleProductIdField.getText();
        String saleQuantity = saleQuantityField.getText();
        int saleQuantityInt = Integer.parseInt(saleQuantity);
        String saleClientId = saleClientIdField.getText();
        String saleTotalAmount = saleTotalAmountField.getText();
        Double saleTotalAmountDouble = Double.parseDouble(saleTotalAmount);
        this.saleService.createSale(saleProductId, saleQuantityInt, saleClientId, saleTotalAmountDouble);
        this.goToSales(event);
    }
}
