package com.ch.models;

import java.io.Serializable;

public class Historical implements Serializable {
    private int id;
    private int courseId;
    private int userId;
    private String time;
    private int learned;
    private String learnTime;
    private String learnProgress;
    private int notesNum;
    private int questionNum;
    private int statue;
    private String learnedSection;
    private String learningHalf;
    private int newLearn;

    public Historical() {
    }

    public Historical(int id, int courseId, int userId, String time, int learned, String learnTime, String learnProgress, int notesNum, int questionNum, int statue, String learnedSection, String learningHalf, int newLearn) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.time = time;
        this.learned = learned;
        this.learnTime = learnTime;
        this.learnProgress = learnProgress;
        this.notesNum = notesNum;
        this.questionNum = questionNum;
        this.statue = statue;
        this.learnedSection = learnedSection;
        this.learningHalf = learningHalf;
        this.newLearn = newLearn;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLearned() {
        return learned;
    }

    public void setLearned(int learned) {
        this.learned = learned;
    }

    public String getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(String learnTime) {
        this.learnTime = learnTime;
    }

    public String getLearnProgress() {
        return learnProgress;
    }

    public void setLearnProgress(String learnProgress) {
        this.learnProgress = learnProgress;
    }

    public int getNotesNum() {
        return notesNum;
    }

    public void setNotesNum(int notesNum) {
        this.notesNum = notesNum;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
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
}
