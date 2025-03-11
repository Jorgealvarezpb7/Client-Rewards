package com.jorgealvarezpb7.client_rewards_app.Models;

public class User {
    private String userName;
    private String password;
    private String userType;

    public User (String userName, String password, String userType) {
    this.userName = userName;
    this.password = password;
    this.userType = userType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}
