package com.ch.models;

import java.io.Serializable;

public class Notes implements Serializable {
    private int id;
    private int userId; // 用户id
    private int sectionId; // 节id
    private int courseId;
    private String courseName;
    private int chapter; // 第几章
    private int section; // 第几节
    private String sectionName;
    private String content; // 发表内容
    private int agreeNum;
    private int gatherNum;
    private String time; // 发表时间

    public Notes() {
    }

    public Notes(int id, int userId, int sectionId, int courseId, String courseName, int chapter, int section, String sectionName, String content, int agreeNum, int gatherNum, String time) {
        this.id = id;
        this.userId = userId;
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.chapter = chapter;
        this.section = section;
        this.sectionName = sectionName;
        this.content = content;
        this.agreeNum = agreeNum;
        this.gatherNum = gatherNum;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", userId=" + userId +
                ", sectionId=" + sectionId +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", chapter=" + chapter +
                ", section=" + section +
                ", sectionName='" + sectionName + '\'' +
                ", content='" + content + '\'' +
                ", agreeNum=" + agreeNum +
                ", gatherNum=" + gatherNum +
                ", time='" + time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
