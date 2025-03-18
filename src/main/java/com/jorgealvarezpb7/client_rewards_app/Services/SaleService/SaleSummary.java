package com.jorgealvarezpb7.client_rewards_app.Services.SaleService;

public class SaleSummary {
    private Double income;
    private int salesNumber;
    private Double average;

    public SaleSummary (double income, int salesNumber, double average) {
        this.income = income;
        this.salesNumber = salesNumber;
        this.average = average;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getIncome() {
        return income;
    }
    
    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }
    
    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}

