package com.ch.models;

public class CourseChapter {
    private String intro;          //课程简介
    private Chapter[] chapters;     //第几章

    public CourseChapter() {
    }

    public CourseChapter(String intro, Chapter[] chapters) {
        this.intro = intro;
        this.chapters = chapters;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Chapter[] getChapters() {
        return chapters;
    }

    public void setChapters(Chapter[] chapters) {
        this.chapters = chapters;
    }
}