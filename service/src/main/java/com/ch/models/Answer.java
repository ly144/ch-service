package com.ch.models;

public class Answer {
    private String img;
    private String name;
    private String content;
    private String time;
    private int agreeNum;
    private int opposeNum;
    private int storey;
    private int answerNum;

    public Answer() {
    }

    public Answer(String img, String name, String content, String time, int agreeNum, int opposeNum, int storey, int answerNum) {
        this.img = img;
        this.name = name;
        this.content = content;
        this.time = time;
        this.agreeNum = agreeNum;
        this.opposeNum = opposeNum;
        this.storey = storey;
        this.answerNum = answerNum;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", agreeNum=" + agreeNum +
                ", opposeNum=" + opposeNum +
                ", storey=" + storey +
                ", answerNum=" + answerNum +
                '}';
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(int agreeNum) {
        this.agreeNum = agreeNum;
    }

    public int getOpposeNum() {
        return opposeNum;
    }

    public void setOpposeNum(int opposeNum) {
        this.opposeNum = opposeNum;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }
}
