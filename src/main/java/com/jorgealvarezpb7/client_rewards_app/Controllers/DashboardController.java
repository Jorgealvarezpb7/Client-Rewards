package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jorgealvarezpb7.client_rewards_app.Models.User;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.ClockService;
import com.jorgealvarezpb7.client_rewards_app.Services.SaleService.SaleSummary;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DashboardController extends AppNav implements Initializable {
    private Authenticated authenticated;

    @FXML private Label saludoUserType;
    @FXML private Label income;
    @FXML private Label sales;
    @FXML private Label average;

    @FXML private Label time;
    @FXML private Label date;
    private ClockService clockService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.authenticated = Authenticated.getInstance();
        User currentUser = this.authenticated.getCurrentUser();
        this.saludoUserType.setText(
                "Bienvenido de vuelta, " + currentUser.getUserName()+ "!" + " Ról: " + currentUser.getUserType());
            
        clockService = new ClockService(time, date);
        clockService.start();
    
         SaleSummary ss = this.authenticated.saleService.dailySummary();
         String ns = Integer.toString(ss.getSalesNumber());

         String ssf = String.format("%.2f", ss.getIncome());
         income.setText(ssf);

         sales.setText(ns);
         
         String ssf2 = String.format("%.2f", ss.getAverage());
         average.setText(ssf2);
    }
} 
  
