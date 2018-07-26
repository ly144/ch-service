package com.ch.models;

public class Detail {
    private String direction;    // 方向
    private String classify;     // 分类
    private String name;         // 课程名称
    private String intro;        // 课程简介
    private String difficulty;   // 课程难度
    private String time;         // 课程时长
    private int people;          // 学习人数
    private String know;         // 课程须知
    private String learnWhat;    // 学到什么
    private String authorImg;    // 老师头像
    private String authorName;   // 老师姓名
    private String authorJob;    // 老师职业
    private int learned;         // 学生学习百分比
    private String learnTime;    // 学生学习耗时
    private String learnProgress;// 学生学至哪里

    public Detail() {}

    public Detail(String direction, String classify, String name, String intro, String difficulty, String time, int people, String know, String learnWhat, String authorImg, String authorName, String authorJob, int learned, String learnTime, String learnProgress) {
        this.direction = direction;
        this.classify = classify;
        this.name = name;
        this.intro = intro;
        this.difficulty = difficulty;
        this.time = time;
        this.people = people;
        this.know = know;
        this.learnWhat = learnWhat;
        this.authorImg = authorImg;
        this.authorName = authorName;
        this.authorJob = authorJob;
        this.learned = learned;
        this.learnTime = learnTime;
        this.learnProgress = learnProgress;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "direction='" + direction + '\'' +
                ", classify='" + classify + '\'' +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", time='" + time + '\'' +
                ", people=" + people +
                ", know='" + know + '\'' +
                ", learnWhat='" + learnWhat + '\'' +
                ", authorImg='" + authorImg + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorJob='" + authorJob + '\'' +
                ", learned=" + learned +
                ", learnTime='" + learnTime + '\'' +
                ", learnProgress='" + learnProgress + '\'' +
                '}';
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getKnow() {
        return know;
    }

    public void setKnow(String know) {
        this.know = know;
    }

    public String getLearnWhat() {
        return learnWhat;
    }

    public void setLearnWhat(String learnWhat) {
        this.learnWhat = learnWhat;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorJob() {
        return authorJob;
    }

    public void setAuthorJob(String authorJob) {
        this.authorJob = authorJob;
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
}
