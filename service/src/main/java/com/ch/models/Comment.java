package com.ch.models;

public class Comment {
    private String img;
    private String name;
    private String content;
    private int agreeNum;
    private String time;

    public Comment() {
    }

    public Comment(String img, String name, String content, int agreeNum, String time) {
        this.img = img;
        this.name = name;
        this.content = content;
        this.agreeNum = agreeNum;
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(int agreeNum) {
        this.agreeNum = agreeNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
