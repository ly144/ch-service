package com.ch.models;

import java.io.Serializable;

public class CourseChapter implements Serializable {
    private int id; // 课程id
    private String name; // 课程名称
    private String difficulty; // 课程难度
    private String uploadTime;
    private String intro;          //课程简介
    private String learnedSection;  // 已经学习记录
    private String learningHalf;    //学至一半记录
    private int newLearn;       // 最新学习
    private Chapter[] chapters;     //第几章

    public CourseChapter() {
    }

    public CourseChapter(int id, String name, String difficulty, String uploadTime, String intro, String learnedSection, String learningHalf, int newLearn, Chapter[] chapters) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.uploadTime = uploadTime;
        this.intro = intro;
        this.learnedSection = learnedSection;
        this.learningHalf = learningHalf;
        this.newLearn = newLearn;
        this.chapters = chapters;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLearnedSection() {
        return learnedSection;
    }

    public void setLearnedSection(String learnedSection) {
        this.learnedSection = learnedSection;
    }

    public String getLearningHalf() {
        return learningHalf;
    }

    public void setLearningHalf(String learningHalf) {
        this.learningHalf = learningHalf;
    }

    public int getNewLearn() {
        return newLearn;
    }

    public void setNewLearn(int newLearn) {
        this.newLearn = newLearn;
    }

    public Chapter[] getChapters() {
        return chapters;
    }

    public void setChapters(Chapter[] chapters) {
        this.chapters = chapters;
    }
}