package com.ch.models;

public class Question {
    private String img;
    private int id;
    private String title;
    private Answer[] answer;
    private int answerNum;
    private int agreeNum;
    private int opposeNum;
    private int lookNum;
    private int chapter;
    private int section;
    private String sectionName;
    private String time;

    public Question() {
    }

    public Question(String img, int id, String title, Answer[] answer, int answerNum, int agreeNum, int opposeNum, int lookNum, int chapter, int section, String sectionName, String time) {
        this.img = img;
        this.id = id;
        this.title = title;
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

    public Question(String img, int id, String title, int answerNum, int agreeNum, int opposeNum, int lookNum, int chapter, int section, String sectionName, String time) {
        this.img = img;
        this.id = id;
        this.title = title;
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
                "img='" + img + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", answer=" + answer +
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
