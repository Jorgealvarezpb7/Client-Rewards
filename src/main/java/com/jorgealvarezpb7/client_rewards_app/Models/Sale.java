package com.jorgealvarezpb7.client_rewards_app.Models;

import java.util.Date;

public class Sale {
    private String productId;
    private int quantity;
    private String clientId;
    private Double totalAmount;
    private Double points;
    private Date createdAt;


    public Sale (String productId, int quantity, String clientId, Double totalAmount, Double points, Date createdAt) { 
        this.productId = productId;
        this.quantity = quantity;
        this.clientId = clientId;
        this.totalAmount = totalAmount;
        this.points = points;
        this.createdAt = createdAt;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
