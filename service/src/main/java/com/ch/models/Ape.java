package com.ch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ape {

    @JsonProperty("type")
    private String name;
    private String title;
    @JsonProperty("myAnswer")
    private String content;
    private String time;
    private String answerNum;

    public Ape() {
    }

    public Ape(String name, String title, String content, String time, String answerNum) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.time = time;
        this.answerNum = answerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
