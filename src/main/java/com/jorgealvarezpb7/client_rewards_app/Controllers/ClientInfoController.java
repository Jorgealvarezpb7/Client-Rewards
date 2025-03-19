package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.Client;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ClientInfoController extends AppNav implements Initializable {

    @FXML private Label nombreCliente;
    @FXML private Label phoneNumber;
    @FXML private Label emailAddress;
    @FXML private Label points;
    @FXML private Label applicableDiscount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Authenticated authenticated = Authenticated.getInstance();
        Client current = authenticated.getActiveClient();

        this.nombreCliente.setText(current.getName());
        double applicableDiscount = current.getPoints().toApplicableDiscount();
        String pointsStr = current.getPoints().toString();

        points.setText(pointsStr);
        String appDisctStr = String.format("%d", (int) applicableDiscount);
        this.applicableDiscount.setText(appDisctStr + "%");

        phoneNumber.setText("movil: " + current.getPhone());
        emailAddress.setText("movil: " + current.getEmail());
    }
}
