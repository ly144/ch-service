package com.ch.models;

import java.io.Serializable;

public class UserLogin implements Serializable {
    private String username;
    private String password;
    private String phone;
    private String code;
    private String picture;
    private int root;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLogin() {
    }

    public UserLogin(String username, String password, String phone, String code, String picture, int root) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.code = code;
        this.picture = picture;
        this.root = root;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", picture='" + picture + '\'' +
                ", root=" + root +
                '}';
    }
}
