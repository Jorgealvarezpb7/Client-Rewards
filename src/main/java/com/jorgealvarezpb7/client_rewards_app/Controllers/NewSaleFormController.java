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
public class NewSaleFormController extends AppNav {
    private Authenticated authenticated;

    @FXML private TextField saleProductIdField;
    @FXML private TextField saleQuantityField;
    @FXML private TextField saleClientIdField;
    @FXML private TextField saleTotalAmountField;

    public NewSaleFormController() {
        this.authenticated = Authenticated.getInstance();
    }

       // Error Labels
    @FXML private Label productIdError;
    @FXML private Label quantityError;
    @FXML private Label clientIdError;
    @FXML private Label totalAmountError;
    @FXML private Label globalError;


    @FXML protected void handleCreateSale(ActionEvent event) throws IOException {
            try {
                productIdError.setText("");
                quantityError.setText("");
                clientIdError.setText("");
                totalAmountError.setText("");
                globalError.setText("");
                

                String saleProductId = saleProductIdField.getText();
                String saleQuantity = saleQuantityField.getText();
                String saleClientId = saleClientIdField.getText();
                String saleTotalAmount = saleTotalAmountField.getText();

                Validator productIdValidator = new Validator()
                .isRequired()
                .isProductId();
            
                productIdValidator.validate("productId", saleProductId);
                
                Validator quantityValidator = new Validator()
                .isRequired()
                .isQuantity(0, 100);

                quantityValidator.validate("quantity", saleQuantity);

                Validator clientIdValidator = new Validator()
                .isRequired()
                .isClientId();
            
                clientIdValidator.validate("clientId", saleClientId);

                Validator totalAmountValidator = new Validator()
                .isRequired()
                .isAmount();

                totalAmountValidator.validate("totalAmount", saleTotalAmount);

                int saleQuantityInt = Integer.parseInt(saleQuantity);
                Double saleTotalAmountDouble = Double.parseDouble(saleTotalAmount);

                this.authenticated.saleService.createSale(saleProductId, saleQuantityInt, saleClientId, saleTotalAmountDouble);
                this.goToSales();
                        } catch (ValidatorError ve) {
                    switch (ve.getField()) {
                        case "productId":
                            this.productIdError.setText(ve.getMessage());
                            break; 
                        case "quantity":
                            this.quantityError.setText(ve.getMessage());
                            break;        
                        case "clientId":
                            this.clientIdError.setText(ve.getMessage());
                            break;
                        case "totalAmount":
                            this.totalAmountError.setText(ve.getMessage());
                            break;
                        default:
                            break;
                    }
                } catch (Exception ex) {
                    this.globalError.setText(ex.getMessage());
                    System.err.println(ex.toString());
                }
            }    
}
