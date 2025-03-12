package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validator;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewProductFormController extends Authenticated{
    @FXML private TextField productNameField;
    @FXML private TextField productIdField;
    @FXML private TextField productQuantityField;
    @FXML private TextField productPriceField;

     // Error Labels
    @FXML private Label quantityError;

    @FXML protected void handleCreateProduct(ActionEvent event) throws IOException {
        try {
            quantityError.setText("");

            String productName = productNameField.getText();
            String productId = productIdField.getText();
            String productQuantity = productQuantityField.getText();
            String productPrice = productPriceField.getText();

            Validator quantityValidator = new Validator()
                .isRequired()
                .isQuantity(0, 100);

            quantityValidator.validate("quantity", productQuantity);

            int productQuantityInt = Integer.parseInt(productQuantity);
            Double productPriceDouble = Double.parseDouble(productPrice);

            this.productService.createProduct(productName, productId, productQuantityInt, productPriceDouble);
            this.goToInventory(event);
    } catch (ValidatorError ve) {
            switch (ve.getField()) {
                case "quantity":
                    this.quantityError.setText(ve.getMessage());
                    break;
                default:
                break;
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }
}
