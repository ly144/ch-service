package com.ch.models;

import java.io.Serializable;

public class CourseLearn implements Serializable {
    private int chapter;
    private int section;
    private String name;
    private String video;

    public CourseLearn() {
    }

    public CourseLearn(int chapter, int section, String name, String video) {
        this.chapter = chapter;
        this.section = section;
        this.name = name;
        this.video = video;
    }

    @Override
    public String toString() {
        return "CourseLearn{" +
                "chapter=" + chapter +
                ", section=" + section +
                ", name='" + name + '\'' +
                ", video='" + video + '\'' +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
