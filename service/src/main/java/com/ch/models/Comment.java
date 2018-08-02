package com.ch.models;

public class Comment {
    private int userId;  // 用户ID
    private int sectionId; // 节ID
    private String img;
    private String name;
    private String content; // 评论内容
    private int chapter;
    private int section;
    private String sectionName;
    private int agreeNum;
    private String time; // 上传时间

    public Comment() {
    }

    public Comment(int userId, int sectionId, String img, String name, String content, int chapter, int section, String sectionName, int agreeNum, String time) {
        this.userId = userId;
        this.sectionId = sectionId;
        this.img = img;
        this.name = name;
        this.content = content;
        this.chapter = chapter;
        this.section = section;
        this.sectionName = sectionName;
        this.agreeNum = agreeNum;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userId=" + userId +
                ", sectionID=" + sectionId +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", chapter=" + chapter +
                ", section=" + section +
                ", sectionName='" + sectionName + '\'' +
                ", agreeNum=" + agreeNum +
                ", time='" + time + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionID(int sectionID) {
        this.sectionId = sectionID;
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
