package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validator;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewClientFormController extends AppNav {
    private Authenticated authenticated;

    @FXML private TextField clientNameField;
    @FXML private TextField clientSurnameField;
    @FXML private TextField clientIdField;
    @FXML private TextField clientPhoneField;
    @FXML private TextField clientEmailField;

    public NewClientFormController() {
        this.authenticated = Authenticated.getInstance();
    }

    // Error Labels
    @FXML private Label nameError;
    @FXML private Label surnameError;
    @FXML private Label clientIdError;
    @FXML private Label phoneError;
    @FXML private Label emailError;

    @FXML protected void handleCreateClient(ActionEvent event) throws IOException {
        try {
            nameError.setText("");
            surnameError.setText("");
            clientIdError.setText("");
            phoneError.setText("");
            emailError.setText("");

            String clientName = clientNameField.getText();
            String clientSurname = clientSurnameField.getText();
            String clientId = clientIdField.getText();
            String clientPhone = clientPhoneField.getText();
            String clientEmail = clientEmailField.getText();

            Validator namesValidator = new Validator()
                .isRequired()
                .isName();

            namesValidator.validate("name", clientName);
            namesValidator.validate("surname", clientSurname);

            Validator clientIdValidator = new Validator()
            .isRequired()
            .isClientId();
    
            clientIdValidator.validate("id", clientId);

            Validator phoneNumValidator = new Validator()
                .isRequired()
                .isPhoneNumber();
            
            phoneNumValidator.validate("phone", clientPhone);

            Validator emailAdresValidator = new Validator()
                .isRequired()
                .isEmailAdress();

            emailAdresValidator.validate("email", clientEmail);

            this.authenticated.clientService.createClient(clientName, clientSurname, clientId, clientPhone, clientEmail);
            this.goToClients();
        } catch (ValidatorError ve) {
            switch (ve.getField()) {
                case "name":
                    this.nameError.setText(ve.getMessage());
                    break;
                case "surname":
                    this.surnameError.setText(ve.getMessage());
                    break;
                case "id":
                    this.clientIdError.setText(ve.getMessage());
                    break;
                case "phone":
                    this.phoneError.setText(ve.getMessage());
                    break;
                case "email":
                    this.emailError.setText(ve.getMessage());
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }
}