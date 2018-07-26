package com.ch.models;

public class Notes {
    private String courseName;
    private int chapter; // 第几章
    private int section; // 第几节
    private String sectionName;
    private String content;
    private int agreeNum;
    private int gatherNum;
    private String time;

    public Notes() {
    }

    public Notes(String courseName, int chapter, int section, String sectionName, String content, int agreeNum, int gatherNum, String time) {
        this.courseName = courseName;
        this.chapter = chapter;
        this.section = section;
        this.sectionName = sectionName;
        this.content = content;
        this.agreeNum = agreeNum;
        this.gatherNum = gatherNum;
        this.time = time;
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

    @Override
    public String toString() {
        return "Notes{" +
                "courseName='" + courseName + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", content='" + content + '\'' +
                ", agreeNum=" + agreeNum +
                ", gatherNum=" + gatherNum +
                ", time='" + time + '\'' +
                '}';
    }
}
