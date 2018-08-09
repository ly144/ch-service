package com.ch.models;

import java.io.Serializable;

public class Person implements Serializable {
    private int id; // 用户id
    private String name; // 用户昵称
    private String picture; // 用户头像
    private String sex; // 用户性别
    private String signature; // 用户个性签名
    private int learnTime; // 学习时长
    private int attentionNum; // 关注数
    private String phone; // 用户电话
    private String email; // 用户邮箱
    private String job; // 用户职业
    private String address; // 用户地址

    public Person() {
    }

    public Person(int id, String name, String picture, String sex, String signature, int learnTime, int attentionNum, String phone, String email, String job, String address) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.sex = sex;
        this.signature = signature;
        this.learnTime = learnTime;
        this.attentionNum = attentionNum;
        this.phone = phone;
        this.email = email;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                ", learnTime=" + learnTime +
                ", attentionNum=" + attentionNum +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
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

    public int getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(int attentionNum) {
        this.attentionNum = attentionNum;
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
}
