package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.User;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.SaleService.SaleSummary;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DashboardController extends AppNav implements Initializable {
    private Authenticated authenticated;

    @FXML private Label saludoUserType;
    @FXML private Label time;
    @FXML private Label date;

    @FXML private Label income;
    @FXML private Label sales;
    @FXML private Label average;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.authenticated = Authenticated.getInstance();
        User currentUser = this.authenticated.getCurrentUser();
        this.saludoUserType.setText(
                "Bienvenido de vuelta, " + currentUser.getUserName()+ "!" + " Ról: " + currentUser.getUserType());

        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            while(true) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e);
                }
                final String timeNow = sdf.format(new Date());
                javafx.application.Platform.runLater(() -> {
                    time.setText(timeNow);
                });
            }
        });thread.start();

        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = sdf2.format(new Date());
        date.setText(dateNow);

     
         SaleSummary ss = this.authenticated.saleService.dailySummary();
         String ns = Integer.toString(ss.getSalesNumber());
         income.setText(ss.getIncome().toString());
         sales.setText(ns);
         average.setText(ss.getAverage().toString());

    }
} 
  
