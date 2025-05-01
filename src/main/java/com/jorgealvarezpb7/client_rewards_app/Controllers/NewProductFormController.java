package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validator;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewProductFormController extends AppNav {
    private Authenticated authenticated;

    @FXML private TextField productNameField;
    @FXML private TextField productIdField;
    @FXML private TextField productQuantityField;
    @FXML private TextField productPriceField;

    public NewProductFormController() {
        this.authenticated = Authenticated.getInstance();
    }

    @FXML private Label nameError;
    @FXML private Label idError;
    @FXML private Label quantityError;
    @FXML private Label priceError;

    @FXML protected void handleCreateProduct(ActionEvent event) throws IOException {
        try {
            nameError.setText("");
            idError.setText("");
            quantityError.setText("");
            priceError.setText("");

            String productName = productNameField.getText();
            String productId = productIdField.getText();
            String productQuantity = productQuantityField.getText();
            String productPrice = productPriceField.getText();

            Validator namesValidator = new Validator()
                .isRequired()
                .isName();

            namesValidator.validate("name", productName);

            Validator productIdValidator = new Validator()
                .isRequired()
                .isProductId();
        
                productIdValidator.validate("id", productId);

            Validator quantityValidator = new Validator()
                .isRequired()
                .isQuantity(0, 100);

            quantityValidator.validate("quantity", productQuantity);

            Validator priceValidator = new Validator()
                .isRequired()
                .isAmount();

                priceValidator.validate("price", productPrice);

            int productQuantityInt = Integer.parseInt(productQuantity);
            Double productPriceDouble = Double.parseDouble(productPrice);

            this.authenticated.productService.createProduct(productName, productId, productQuantityInt, productPriceDouble);
            this.goToInventory();
        } catch (ValidatorError ve) {
            switch (ve.getField()) {
                case "name":
                    this.nameError.setText(ve.getMessage());
                    break;
                case "id":
                    this.idError.setText(ve.getMessage());
                    break;
                case "quantity":
                    this.quantityError.setText(ve.getMessage());
                    break;
                case "price":
                    this.priceError.setText(ve.getMessage());
                    break;
                default:
                break;
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }
}
