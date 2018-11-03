package com.salon.cattocdi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("grant_type")
    private String grantType;
    @SerializedName("access_token")
    private String access_token;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        grantType = "password";
    }

    public Account() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
