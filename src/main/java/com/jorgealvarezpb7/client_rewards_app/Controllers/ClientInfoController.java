package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.Client;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.SaleService.RecurrentPurchase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ClientInfoController extends AppNav implements Initializable {

    @FXML
    private Label nombreCliente;
    @FXML
    private Label phoneNumber;
    @FXML
    private Label emailAddress;
    @FXML
    private Label points;
    @FXML
    private Label applicableDiscount;

    @FXML
    private Label topProduct1;
    @FXML
    private Label topProduct2;
    @FXML
    private Label topProduct3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Authenticated authenticated = Authenticated.getInstance();
        Client current = authenticated.getActiveClient();

        this.nombreCliente.setText(current.getName());

        int pointsValue = current.getPoints().getInner();
        int applicableDiscountValue = (int) Math.round(pointsValue * 0.10f);

        points.setText(current.getPoints().toString());
        this.applicableDiscount.setText(applicableDiscountValue + "%");

        phoneNumber.setText("movil: " + current.getPhone());
        emailAddress.setText("correo: " + current.getEmail());

        ArrayList<RecurrentPurchase> rp = authenticated.saleService.customerTop3Purchases(current.getId());

        try {
            RecurrentPurchase rp1 = rp.get(0);

            if (rp1 != null) {
                topProduct1.setText(rp1.toListString());
            }

            RecurrentPurchase rp2 = rp.get(1);

            if (rp2 != null) {
                topProduct2.setText(rp2.toListString());
            }

            RecurrentPurchase rp3 = rp.get(2);

            if (rp3 != null) {
                topProduct3.setText(rp3.toListString());
            }
        } catch (Exception e) {
            System.out.println("On ClientInfo: " + e.toString());
        }
    }
}
