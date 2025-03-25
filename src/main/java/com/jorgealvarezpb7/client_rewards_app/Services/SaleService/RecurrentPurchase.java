package com.jorgealvarezpb7.client_rewards_app.Services.SaleService;

public class RecurrentPurchase {
    private String name;
    private int totalQ;

    public RecurrentPurchase (String name, int totalQ){
        this.name = name;
        this.totalQ = totalQ;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTotalQ() {
        return totalQ;
    }
    public void setTotalQ(int totalQ) {
        this.totalQ = totalQ;
    }

    public String toListString () {
        return this.name + "(" + this.totalQ + ")";
    }
}
