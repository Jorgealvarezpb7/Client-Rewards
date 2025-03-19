package com.jorgealvarezpb7.client_rewards_app.Models;

public class Points {
    private final static double FACTOR = 0.10;
    private int inner;

    private Points(double value) {
        this.inner = (int) value;
    }

    public int getInner() {
        return inner;
    }

    public void setInner(int inner) {
        this.inner = inner;
    }

    public static Points fromPurchase(double amount) {
        return new Points((int) amount);
    }

    public static Points fromDouble(double value) {
        return new Points(value);
    }

    public double toApplicableDiscount() {
        return this.inner / 0.10;
    }

    @Override
    public String toString() {
        return Integer.toString(this.inner);
    }
}
