package com.ch.models;

import java.io.Serializable;

public class Answer implements Serializable {
    private int userId; // 回答者用户id
    private int questionId; // 问答id
    private int communityId; // 猿问问题id
    private String img;   // 回答者用户头像
    private String name;  // 回答者姓名
    private String content;  // 回答内容
    private String time;    // 回答时间
    private int agreeNum;  // 赞同数
    private int opposeNum;  // 反对数
    private int storey;  // 楼层数
    private int answerNum;  // 回复数

    public Answer() {
    }

    public Answer(int userId, int questionId, int communityId, String img, String name, String content, String time, int agreeNum, int opposeNum, int storey, int answerNum) {
        this.userId = userId;
        this.questionId = questionId;
        this.communityId = communityId;
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
                "userId=" + userId +
                ", questionId=" + questionId +
                ", communityId=" + communityId +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", agreeNum=" + agreeNum +
                ", opposeNum=" + opposeNum +
                ", storey=" + storey +
                ", answerNum=" + answerNum +
                '}';
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
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
