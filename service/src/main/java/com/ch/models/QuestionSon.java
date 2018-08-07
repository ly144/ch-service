package com.ch.models;

import java.io.Serializable;

public class QuestionSon implements Serializable {
    private String directions; // 方向
    private String classify; // 分类
    private String courseName; // 课程名
    private String name; // 提问者姓名
    private String picture; // 提问者头像
    private String title;// 提问问题
    private String content; // 提问内容
    private String time; // 提问时间
    private int chapter; // 第几章
    private int section; // 第几节
    private int answerNum; // 回答数
    private int lookNum; // 浏览数

    public QuestionSon() {
    }

    public QuestionSon(String directions, String classify, String courseName, String name, String picture, String title, String content, String time, int chapter, int section, int answerNum, int lookNum) {
        this.directions = directions;
        this.classify = classify;
        this.courseName = courseName;
        this.name = name;
        this.picture = picture;
        this.title = title;
        this.content = content;
        this.time = time;
        this.chapter = chapter;
        this.section = section;
        this.answerNum = answerNum;
        this.lookNum = lookNum;
    }

    @Override
    public String toString() {
        return "QuestionSon{" +
                "directions='" + directions + '\'' +
                ", classify='" + classify + '\'' +
                ", courseName='" + courseName + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", chapter=" + chapter +
                ", section=" + section +
                ", answerNum=" + answerNum +
                ", lookNum=" + lookNum +
                '}';
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public int getLookNum() {
        return lookNum;
    }

    public void setLookNum(int lookNum) {
        this.lookNum = lookNum;
    }
}
