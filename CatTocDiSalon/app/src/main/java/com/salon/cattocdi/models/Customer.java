package com.salon.cattocdi.models;

import com.google.gson.annotations.SerializedName;
import com.salon.cattocdi.models.Appointment;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String phone;
    private String email;
    @SerializedName("access_token")
    private String token;
    private List<Appointment> appointments;

    public Customer() {
    }

    public Customer(int id, String name, String phone, String email, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.appointments = appointments;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmai() {
        return email;
    }

    public void setEmai(String emai) {
        this.email = emai;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
