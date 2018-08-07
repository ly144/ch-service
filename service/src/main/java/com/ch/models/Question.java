package com.ch.models;

import java.io.Serializable;
import java.util.Arrays;

public class Question implements Serializable {
    private int userId;  // 用户ID
    private int sectionId; // 节ID
    private String img;
    private int id;
    private String title;  // 题目
    private String content; // 题目内容
    private Answer[] answer;
    private int answerNum;
    private int agreeNum;
    private int opposeNum;
    private int lookNum;
    private int chapter;
    private int section;
    private String sectionName;
    private String time; // 发布时间

    public Question() {
    }

    public Question(int userId, int sectionId, String img, int id, String title, String content, Answer[] answer, int answerNum, int agreeNum, int opposeNum, int lookNum, int chapter, int section, String sectionName, String time) {
        this.userId = userId;
        this.sectionId = sectionId;
        this.img = img;
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.answerNum = answerNum;
        this.agreeNum = agreeNum;
        this.opposeNum = opposeNum;
        this.lookNum = lookNum;
        this.chapter = chapter;
        this.section = section;
        this.sectionName = sectionName;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Question{" +
                "userId=" + userId +
                ", sectionId=" + sectionId +
                ", img='" + img + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", answer=" + Arrays.toString(answer) +
                ", answerNum=" + answerNum +
                ", agreeNum=" + agreeNum +
                ", opposeNum=" + opposeNum +
                ", lookNum=" + lookNum +
                ", chapter=" + chapter +
                ", section=" + section +
                ", sectionName='" + sectionName + '\'' +
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

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Answer[] getAnswer() {
        return answer;
    }

    public void setAnswer(Answer[] answer) {
        this.answer = answer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public int getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(int agreeNum) {
        this.agreeNum = agreeNum;
    }

    public int getOpposeNum() {
        return opposeNum;
    }

    public void setOpposeNum(int opposeNum) {
        this.opposeNum = opposeNum;
    }

    public int getLookNum() {
        return lookNum;
    }

    public void setLookNum(int lookNum) {
        this.lookNum = lookNum;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
