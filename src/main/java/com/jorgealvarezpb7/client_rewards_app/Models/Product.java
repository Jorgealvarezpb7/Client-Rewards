package com.jorgealvarezpb7.client_rewards_app.Models;

public class Product {
    private String name;
    private String code;
    private int quantity;
    private int price;

    public Product(String name, String code, int quantity, int price) { 
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
