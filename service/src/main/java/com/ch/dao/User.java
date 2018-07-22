package com.ch.dao;

public class User {
    private int id;
    private String name;
    private String password;
    private String picture;
    private String phone;
    private String sex;
    private String email;
    private String signature;
    private int root;

    public User() {
    }

    public User(int id, String name, String password, String picture, String phone, String sex, String email, String signature, int root) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.picture = picture;
        this.phone = phone;
        this.sex = sex;
        this.email = email;
        this.signature = signature;
        this.root = root;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", signature='" + signature + '\'' +
                ", root=" + root +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPicture() {
        return picture;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getSignature() {
        return signature;
    }

    public int getRoot() {
        return root;
    }
}
