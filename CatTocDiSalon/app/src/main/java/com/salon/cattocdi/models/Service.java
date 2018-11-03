package com.salon.cattocdi.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Service implements Serializable{
    @SerializedName("ServiceId")
    private int id;
    @SerializedName("Name")
    private String name;
    private float price;
    private int minutes;

    public Service(int id, String name, float price, int minutes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.minutes = minutes;
    }

    public Service() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
