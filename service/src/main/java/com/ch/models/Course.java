package com.ch.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(indexName = "sleep", type = "course")
public class Course implements Serializable {

    // 获得首页推荐课程详细信息
    @Id
    private Integer id;              // 课程编号
    private int typeId;          // 类型编号
    private String img;          // 课程图像
    private String name;         // 课程名称
    private int userId;          // 教师ID
    private String shortIntro;   // 课程简短介绍
    private String intro;        // 课程简介
    private String difficulty;   // 课程难度
    private String time;         // 课程时长
    private int people;          // 学习人数
    private String uploadTime;   // 课程上传时间
    private String know;         // 课程须知
    private String learnWhat;    // 学到什么

    public Course() {
    }

    public Course(int id, int typeId, String img, String name, int userId, String shortIntro, String intro, String difficulty, String time, int people, String uploadTime, String know, String learnWhat) {
        this.id = id;
        this.typeId = typeId;
        this.img = img;
        this.name = name;
        this.userId = userId;
        this.shortIntro = shortIntro;
        this.intro = intro;
        this.difficulty = difficulty;
        this.time = time;
        this.people = people;
        this.uploadTime = uploadTime;
        this.know = know;
        this.learnWhat = learnWhat;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", shortIntro='" + shortIntro + '\'' +
                ", intro='" + intro + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", time='" + time + '\'' +
                ", people=" + people +
                ", uploadTime='" + uploadTime + '\'' +
                ", know='" + know + '\'' +
                ", learnWhat='" + learnWhat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return typeId == course.typeId &&
                id == course.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, typeId, img, name, userId, shortIntro, intro, difficulty, time, people, uploadTime, know, learnWhat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getShortIntro() {
        return shortIntro;
    }

    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
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

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
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
}
