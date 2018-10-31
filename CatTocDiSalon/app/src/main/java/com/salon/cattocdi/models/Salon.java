package com.salon.cattocdi.models;

public class Salon {
    private String name;
    private float ratingNumber;
    private boolean full;
    private int discount;

    public Salon() {
    }

    public String getName() {
        return name;
    }

    public Salon setName(String name) {
        this.name = name;
        return this;
    }

    public float getRatingNumber() {
        return ratingNumber;
    }

    public Salon setRatingNumber(float ratingNumber) {
        this.ratingNumber = ratingNumber;
        return this;
    }

    public boolean isFull() {
        return full;
    }

    public Salon setFull(boolean full) {
        this.full = full;
        return this;
    }

    public int getDiscount() {
        return discount;
    }

    public Salon setDiscount(int discount) {
        this.discount = discount;
        return this;
    }
}
