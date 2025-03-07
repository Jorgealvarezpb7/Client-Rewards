package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewSaleFormController extends Authenticated{
    @FXML private TextField saleProductField;
    @FXML private TextField saleQuantityField;
    @FXML private TextField saleClientField;
    @FXML private TextField saleTotal_AmountField;

    @FXML protected void handleCreateSale(ActionEvent event) throws IOException {
        String saleProduct = saleProductField.getText();
        String saleQuantity = saleQuantityField.getText();
        int saleQuantityInt = Integer.parseInt(saleQuantity);
        String saleClient = saleClientField.getText();
        String saleTotal_Amount = saleTotal_AmountField.getText();
        int saleTotal_AmountInt = Integer.parseInt(saleTotal_Amount);
        this.saleService.createSale(saleProduct, saleQuantityInt, saleClient, saleTotal_AmountInt);
        App.setRoot("Views/Sales/template");
    }
}
