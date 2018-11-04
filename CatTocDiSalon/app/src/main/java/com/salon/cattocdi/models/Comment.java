package com.salon.cattocdi.models;

import java.util.Date;

public class Comment {
    private String customerName;
    private int rating;
    private Date date;
    private String content;

    public Comment(String customerName, int rating, Date date, String content) {
        this.customerName = customerName;
        this.rating = rating;
        this.date = date;
        this.content = content;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
