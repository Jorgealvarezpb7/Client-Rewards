package com.jorgealvarezpb7.client_rewards_app.Services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.controlsfx.tools.Platform;

import com.jorgealvarezpb7.client_rewards_app.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Authenticated {
    protected Database db;
    public ClientService clientService;
    public ProductService productService;
    public SaleService saleService;

    //@FXML private Label dateAndTime;

    //public User currentUser;

    public volatile boolean stop = false;

    public Authenticated() {
        db = new Database();
        db.runMigrations();
        clientService = new ClientService();
        productService = new ProductService();
        saleService = new SaleService();

        


        //currentUser = new CurrentUser();
    }

    @FXML
    protected void goToClients(ActionEvent event) throws IOException {
        App.setRoot("Views/Clients/template");
    }

    @FXML
    protected void goToDashboard(ActionEvent event) throws IOException {
        App.setRoot("Views/Dashboard/template");
    }

    @FXML
    protected void goToInventory(ActionEvent event) throws IOException {
        App.setRoot("Views/Inventory/template");
    }

    @FXML
    protected void goToSales(ActionEvent event) throws IOException {
        App.setRoot("Views/Sales/template");
    }

    @FXML
    protected void goToClientInfo(ActionEvent event) throws IOException {
        App.setRoot("Views/ClientInfo/template");
    }

    @FXML
    protected void goToNewClientForm(ActionEvent event) throws IOException {
        App.setRoot("Views/NewClientForm/template");
    }

    @FXML
    protected void goToNewProductForm(ActionEvent event) throws IOException {
        App.setRoot("Views/NewProductForm/template");
    }

    @FXML
    protected void goToNewSaleForm(ActionEvent event) throws IOException {
        App.setRoot("Views/NewSaleForm/template");
    }

    @FXML
    protected void signOut(ActionEvent event) throws IOException {
        App.setRoot("Views/Auth/template");
    }

    public void timeNow() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                final String timeNow = sdf.format(new Date());
                javafx.application.Platform.runLater(()->{
                    System.out.println(timeNow);
                    //time.setText(timeNow);
                }); 
            }
        });
        thread.start();
    }

        public void dateNow () {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateNow = sdf.format(new Date());
        System.out.println(dateNow);
        //time.setText(dateNow);
    }


}