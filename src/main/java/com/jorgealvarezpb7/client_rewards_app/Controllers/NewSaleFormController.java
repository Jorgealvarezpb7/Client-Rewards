package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.Client;
import com.jorgealvarezpb7.client_rewards_app.Models.Product;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.ClientService;
import com.jorgealvarezpb7.client_rewards_app.Services.ProductService;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validator;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class NewSaleFormController extends AppNav implements Initializable {
    private Authenticated authenticated;

    @FXML private ComboBox<String> saleProductIdCbox;
    @FXML private TextField saleQuantityField;
    @FXML private ComboBox<String> saleClientIdCbox;
    @FXML private TextField saleTotalAmountField;

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
    ProductService productService = new ProductService();
    ClientService clientService = new ClientService();


    ArrayList<Client> clientes = clientService.listClients();
    if (clientes != null) {
        for (Client cliente : clientes) {
            saleClientIdCbox.getItems().add(cliente.getId());
        }
    }

    ArrayList<Product> productos = productService.listProducts();
    if (productos != null) {
        for (Product producto : productos) {
            saleProductIdCbox.getItems().add(producto.getId());
        }
    }
}

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
                
                String saleProductId = saleProductIdCbox.getValue();
                String saleQuantity = saleQuantityField.getText();
                String saleClientId = saleClientIdCbox.getValue();
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
