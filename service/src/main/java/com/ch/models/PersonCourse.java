package com.ch.models;

import java.io.Serializable;

public class PersonCourse implements Serializable {
    private String time;
    private String img;
    private String name;
    private String learned;
    private String learnTime;
    private String learnProgress;
    private String notesNum;
    private String questionNum;

    public PersonCourse() {
    }

    public PersonCourse(String time, String img, String name, String learned, String learnTime, String learnProgress, String notesNum, String questionNum) {
        this.time = time;
        this.img = img;
        this.name = name;
        this.learned = learned;
        this.learnTime = learnTime;
        this.learnProgress = learnProgress;
        this.notesNum = notesNum;
        this.questionNum = questionNum;
    }

    public String getTime() {
        return time;
    }

    public void setYear(String time) {
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

    public void setTime(String time) {
        this.time = time;
    }

    public String getLearned() {
        return learned;
    }

    public void setLearned(String learned) {
        this.learned = learned;
    }

    public void setNotesNum(String notesNum) {
        this.notesNum = notesNum;
    }

    public String getLearnProgress() {
        return learnProgress;
    }

    public void setLearnProgress(String learnProgress) {
        this.learnProgress = learnProgress;
    }

    public String getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(String learnTime) {
        this.learnTime = learnTime;
    }

    public String getNotesNum() {
        return notesNum;
    }

    public void setNoteNum(String notesNum) {
        this.notesNum = notesNum;
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }
}
