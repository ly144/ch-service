package com.ch.models;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String password;
    private String picture;
    private String sex;
    private String signature;
    private int learnTime;
    private int attenionNum;
    private String phone;
    private String email;
    private String job;
    private String address;
    private int root;

    public User() {
    }

    public User(int id, String name, String password, String picture, String sex, String signature, int learnTime, int attenionNum, String phone, String email, String job, String address, int root) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.picture = picture;
        this.sex = sex;
        this.signature = signature;
        this.learnTime = learnTime;
        this.attenionNum = attenionNum;
        this.phone = phone;
        this.email = email;
        this.job = job;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(int learnTime) {
        this.learnTime = learnTime;
    }

    public int getAttenionNum() {
        return attenionNum;
    }

    public void setAttenionNum(int attenionNum) {
        this.attenionNum = attenionNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }
}
