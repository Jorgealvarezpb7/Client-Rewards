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

public class NewClientFormController extends Authenticated {
    @FXML private TextField clientNameField;
    @FXML private TextField clientSurnameField;
    @FXML private TextField clientSurname2Field;
    @FXML private TextField clientPhoneField;
    @FXML private TextField clientEmailField;

    // Error Labels
    @FXML private Label nameError;
    @FXML private Label surnameError;
    @FXML private Label surname2Error;
    @FXML private Label phoneError;
    @FXML private Label emailError;

    @FXML protected void handleCreateClient(ActionEvent event) throws IOException {
        try {
            nameError.setText("");
            surnameError.setText("");
            phoneError.setText("");
            emailError.setText("");

            String clientName = clientNameField.getText();
            String clientSurname = clientSurnameField.getText();
            String clientSurname2 = clientSurname2Field.getText();
            String clientPhone = clientPhoneField.getText();
            String clientEmail = clientEmailField.getText();

            Validator namesValidator = new Validator()
                .isRequired();
            
            namesValidator.validate("name", clientName);
            namesValidator.validate("surname", clientSurname);
            namesValidator.validate("surname2", clientSurname2);

            Validator phoneNumValidator = new Validator()
                .isRequired()
                .isPhoneNumber();
            
            phoneNumValidator.validate("phone", clientPhone);

            Validator emailAdresValidator = new Validator()
                .isRequired()
                .isEmailAdress();

            emailAdresValidator.validate("email", clientEmail);


            this.clientService.createClient(clientName, clientSurname, clientSurname2, clientPhone, clientEmail);
            this.goToClients(event);
        } catch (ValidatorError ve) {
            switch (ve.getField()) {
                case "name":
                    this.nameError.setText(ve.getMessage());
                    break;
                case "surname":
                    this.surnameError.setText(ve.getMessage());
                    break;
                    case "surname2":
                    this.surname2Error.setText(ve.getMessage());
                    break;
                case "phone":
                    this.phoneError.setText(ve.getMessage());
                    case "email":
                    this.emailError.setText(ve.getMessage());
                default:
                    break;
            }
        } catch (Exception ex) {
            // hanhli
        }
    }
}