package com.ch.models;

import java.util.Arrays;

public class Community {
    private int id;  //获取提问者id
    private String img; // 分类头像
    private String classify; // 类型
    private int userId; // 提问者id
    private int typeId; // 类型id
    private String quesImg;  //获取提问者头像
    private String quesName;  //获取提问者姓名
    private String title; // 题目
    private String content; // 题目具体内容,ape组件无需展示
    private Answer[] answer; // 回答
    private int answerNum; // 回答数目
    private int lookNum;  // 浏览数
    private String time; // 发布时间
    private int attentionNum; // 关注数

    public Community() {
    }

    public Community(int id, String img, String classify, int userId, int typeId, String quesImg, String quesName, String title, String content, Answer[] answer, int answerNum, int lookNum, String time, int attentionNum) {
        this.id = id;
        this.img = img;
        this.classify = classify;
        this.userId = userId;
        this.typeId = typeId;
        this.quesImg = quesImg;
        this.quesName = quesName;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.answerNum = answerNum;
        this.lookNum = lookNum;
        this.time = time;
        this.attentionNum = attentionNum;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", classify='" + classify + '\'' +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", quesImg='" + quesImg + '\'' +
                ", quesName='" + quesName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", answer=" + Arrays.toString(answer) +
                ", answerNum=" + answerNum +
                ", lookNum=" + lookNum +
                ", time='" + time + '\'' +
                ", attentionNum=" + attentionNum +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getQuesImg() {
        return quesImg;
    }

    public void setQuesImg(String quesImg) {
        this.quesImg = quesImg;
    }

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Answer[] getAnswer() {
        return answer;
    }

    public void setAnswer(Answer[] answer) {
        this.answer = answer;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public int getLookNum() {
        return lookNum;
    }

    public void setLookNum(int lookNum) {
        this.lookNum = lookNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(int attentionNum) {
        this.attentionNum = attentionNum;
    }
}
