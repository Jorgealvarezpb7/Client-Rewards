package com.jorgealvarezpb7.client_rewards_app.Services;

import java.util.ArrayList;
import java.util.List;

import com.jorgealvarezpb7.client_rewards_app.Models.Client;
import com.jorgealvarezpb7.client_rewards_app.Models.User;
import com.jorgealvarezpb7.client_rewards_app.Services.SaleService.SaleService;

public final class Authenticated {
    protected Database db;
    public ClientService clientService;
    public ProductService productService;
    public SaleService saleService;
    public User currentUser;
    public UserService userService;


    private Client activeClient = null;

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
        userService = new UserService(db);
        saleService = new SaleService(clientService, productService);
        currentUser = null;
    }

    public static Authenticated getInstance() {
        return Authenticated.INSTANCE;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public boolean authenticate(String username, String password) {
        System.out.println("Auth: " + username + " : " + password);
    
        if (username.equals(ADMIN_USER_NAME) && password.equals(ADMIN_USER_PSWD)) {
            this.currentUser = new User(username, password, "admin");
            return true;
        }
    
        User foundUser = userService.findUser(username, password);
        if (foundUser != null) {
            this.currentUser = foundUser;
            return true;
        }
    
        return false;
    }

    public void setActiveClient(Client activeClient) {
        this.activeClient = activeClient;
    }

    public Client getActiveClient() {
        return activeClient;
    }

    public boolean register(String username, String password) {
        return userService.registerUser(username, password, "basic");
    }
}