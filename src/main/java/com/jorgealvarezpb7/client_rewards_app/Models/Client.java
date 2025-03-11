package com.jorgealvarezpb7.client_rewards_app.Models;

public class Client {
    private String name;
    private String surname;
    private String surname2;
    private String phone;
    private String email;

    public Client(String name, String surname, String surname2, String phone, String email) { 
        this.name = name;
        this.surname = surname;
        this.surname2 = surname2;
        this.phone = phone;
        this.email = email;
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

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getSurname2() {
        return surname2;
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
}
