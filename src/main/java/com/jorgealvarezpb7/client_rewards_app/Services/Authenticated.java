package com.jorgealvarezpb7.client_rewards_app.Services;

import java.io.IOException;

//import org.controlsfx.tools.Platform;

import com.jorgealvarezpb7.client_rewards_app.App;
import com.jorgealvarezpb7.client_rewards_app.Models.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class Authenticated {
    protected Database db;
    public ClientService clientService;
    public ProductService productService;
    public SaleService saleService;
    public User currentUser;

    public volatile boolean stop = false;

    private static final String ADMIN_USER_NAME = "admin";
    private static final String ADMIN_USER_PSWD = "admin";

    private static final String BASIC_USER_NAME = "user";
    private static final String BASIC_USER_PSWD = "user";

    private final static Authenticated INSTANCE = new Authenticated();

    private Authenticated() {
        db = new Database();
        db.runMigrations();
        clientService = new ClientService();
        productService = new ProductService();
        saleService = new SaleService();
        currentUser = null;
    }

    public static Authenticated getInstance() {
        return Authenticated.INSTANCE;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public boolean authenticate(String user, String pass) {
        System.out.println("Auth: " + user + " : " + pass);

        if (user.equals(Authenticated.ADMIN_USER_NAME) && pass.equals(Authenticated.ADMIN_USER_PSWD)) {
            this.currentUser = new User(user, pass, "admin");
            return true;
        }

        if (user.equals(Authenticated.BASIC_USER_NAME) && pass.equals(Authenticated.BASIC_USER_PSWD)) {
            this.currentUser = new User(user, pass, "basic");
            return true;
        }

        return false;
    }

}