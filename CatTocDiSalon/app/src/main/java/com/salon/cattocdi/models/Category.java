package com.salon.cattocdi.models;

import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Service> services;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(int id, String name, List<Service> services) {
        this.id = id;
        this.name = name;
        this.services = services;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
