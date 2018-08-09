package com.ch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Ape implements Serializable {

    private int id;
    @JsonProperty("type")
    private String name;
    private String img;
    private String title;
    @JsonProperty("myAnswer")
    private String content;
    private String time;
    private String answerNum;

    public Ape() {
    }

    public Ape(int id, String name, String img, String title, String content, String time, String answerNum) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.title = title;
        this.content = content;
        this.time = time;
        this.answerNum = answerNum;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(String answerNum) {
        this.answerNum = answerNum;
    }
}
