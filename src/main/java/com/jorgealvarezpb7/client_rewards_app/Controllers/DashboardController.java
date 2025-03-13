package com.jorgealvarezpb7.client_rewards_app.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jorgealvarezpb7.client_rewards_app.Models.User;
import com.jorgealvarezpb7.client_rewards_app.Services.AppNav;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController extends AppNav {
    private Authenticated authenticated;

    @FXML private Label saludoUserType;
    @FXML private Label time;
    @FXML private Label date;

    public DashboardController (){
        this.authenticated = Authenticated.getInstance();
        User currentUser = this.authenticated.getCurrentUser();

        if (currentUser != null) {
            System.out.println(currentUser);
            if (this.saludoUserType != null) {
                this.saludoUserType.setText(currentUser.getUserName());
            }
        }
    
        // Thread thread = new Thread(() -> {
        //     SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        //     while (!stop) {
        //         try {
        //             Thread.sleep(1000);
        //         } catch (Exception e) {
        //             System.out.println(e);
        //         }
        //         final String timeNow = sdf.format(new Date());
        //         javafx.application.Platform.runLater(()->{
        //             time.setText(timeNow);
        //         }); 
        //     }
        // });
        // thread.start();

        // SimpleDateFormat sdf2 = new SimpleDateFormat("MMM/dd/yyyy");
        // String dateNow = sdf2.format(new Date());
        // date.setText(dateNow);
    }

    
    

}
