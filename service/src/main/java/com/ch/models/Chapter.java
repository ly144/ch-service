package com.ch.models;

import java.io.Serializable;

public class Chapter implements Serializable {
    private int id;            // 章ID
    private int courseId; // 课程ID
    private int chapter;       // 第几章
    private String name ;      // 章节名
    private String summary;    // 章节简介
    private Sections[] sections; //第几节

    public Chapter() {
    }

    public Chapter(int id, int courseId, int chapter, String name, String summary, Sections[] sections) {
        this.id = id;
        this.courseId = courseId;
        this.chapter = chapter;
        this.name = name;
        this.summary = summary;
        this.sections = sections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Sections[] getSections() {
        return sections;
    }

    public void setSections(Sections[] sections) {
        this.sections = sections;
    }
}
