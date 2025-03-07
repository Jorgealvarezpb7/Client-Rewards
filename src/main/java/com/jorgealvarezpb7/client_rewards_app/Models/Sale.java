package com.jorgealvarezpb7.client_rewards_app.Models;

public class Sale {
    private String product;
    private int quantity;
    private String client;
    private int total_Amount;

    public Sale (String product, int quantity, String client, int total_Amount) { 
        this.product = product;
        this.quantity = quantity;
        this.client = client;
        this.total_Amount = total_Amount;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setTotal_Amount(int total_Amount) {
        this.total_Amount = total_Amount;
    }

    public int getTotal_Amount() {
        return total_Amount;
    }
}
