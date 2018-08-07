package com.ch.models;

import java.io.Serializable;

public class Sections implements Serializable {
    private int id;         //节ID
    private int chapterId; // 章id
    private int section;    //第几节
    private String name;   // 节名
    private String time;            // 节时长
    private String learnedSection;  // 已经学习记录
    private int learnedSections;  // 已经学习（前台）
    private String learningHalf;    //学至一半记录
    private int learningHalfs;    // 学至一半（前台）
    private int newLearn;       // 最新学习

    public Sections() {
    }

    public Sections(int id, int chapterId, int section, String name, String time, String learnedSection, int learnedSections, String learningHalf, int learningHalfs, int newLearn) {
        this.id = id;
        this.chapterId = chapterId;
        this.section = section;
        this.name = name;
        this.time = time;
        this.learnedSection = learnedSection;
        this.learnedSections = learnedSections;
        this.learningHalf = learningHalf;
        this.learningHalfs = learningHalfs;
        this.newLearn = newLearn;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLearnedSection() {
        return learnedSection;
    }

    public void setLearnedSection(String learnedSection) {
        this.learnedSection = learnedSection;
    }

    public int getLearnedSections() {
        return learnedSections;
    }

    public void setLearnedSections(int learnedSections) {
        this.learnedSections = learnedSections;
    }

    public String getLearningHalf() {
        return learningHalf;
    }

    public void setLearningHalf(String learningHalf) {
        this.learningHalf = learningHalf;
    }

    public int getLearningHalfs() {
        return learningHalfs;
    }

    public void setLearningHalfs(int learningHalfs) {
        this.learningHalfs = learningHalfs;
    }

    public int getNewLearn() {
        return newLearn;
    }

    public void setNewLearn(int newLearn) {
        this.newLearn = newLearn;
    }
}