package com.salon.cattocdi.models;

import com.salon.cattocdi.models.Appointment;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String phone;
    private String emai;
    private List<Appointment> appointments;

    public Customer() {
    }

    public Customer(int id, String name, String phone, String emai, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.emai = emai;
        this.appointments = appointments;
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
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
