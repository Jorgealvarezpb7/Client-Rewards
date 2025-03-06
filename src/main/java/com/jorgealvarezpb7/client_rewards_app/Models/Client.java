package com.jorgealvarezpb7.client_rewards_app.Models;

public class Client {
    private String name;
    private String surname;

    public Client(String name, String surname) { 
        this.name = name;
        this.surname = surname;
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
}
