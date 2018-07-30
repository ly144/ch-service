package com.ch.models;

public class Comment {
    private String img;
    private String name;
    private String content;
    private int chapter;
    private int section;
    private String sectionName;
    private int agreeNum;
    private String time;

    public Comment() {
    }

    public Comment(String img, String name, String content, int chapter, int section, String sectionName, int agreeNum, String time) {
        this.img = img;
        this.name = name;
        this.content = content;
        this.chapter = chapter;
        this.section = section;
        this.sectionName = sectionName;
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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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
