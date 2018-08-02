package com.ch.models;

public class CourseNotes {
    private String img; // 用户头像
    private String name; //用户名
    private int chapter; // 第几章
    private int section; // 第几节
    private String sectionName; // 节名
    private String content;
    private int agreeNum;
    private int gatherNum;
    private String time;

    public CourseNotes() {
    }

    public CourseNotes(String img, String name, int chapter, int section, String sectionName, String content, int agreeNum, int gatherNum, String time) {
        this.img = img;
        this.name = name;
        this.chapter = chapter;
        this.section = section;
        this.sectionName = sectionName;
        this.content = content;
        this.agreeNum = agreeNum;
        this.gatherNum = gatherNum;
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

    public int getGatherNum() {
        return gatherNum;
    }

    public void setGatherNum(int gatherNum) {
        this.gatherNum = gatherNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
