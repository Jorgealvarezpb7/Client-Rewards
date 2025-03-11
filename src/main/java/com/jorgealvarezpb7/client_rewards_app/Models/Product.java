package com.jorgealvarezpb7.client_rewards_app.Models;

import java.util.Date;

public class Product {
    private String name;
    private String id;
    private int quantity;
    private Double price;
    private Date createdAt;


    public Product(String name, String id, int quantity, Double price, Date createdAt) { 
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
