package com.jorgealvarezpb7.client_rewards_app.Models;

import java.util.Date;

public class Client {
    private String name;
    private String surname;
    private String id;
    private Double points;
    private String phone;
    private String email;
    private Date createdAt;

    public Client(String name, String surname, String id, Double points, String phone, String email, Date createdAt) { 
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.points = points;
        this.phone = phone;
        this.email = email;
        this.createdAt = createdAt;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

}
