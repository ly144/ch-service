package com.ch.service;

import com.ch.models.*;

public interface CourseService {
    // 获得首页推荐课程详细信息
    Course[] getCourse();

    // 获取课程学习视频
    CourseLearn getCourseLearn(int id);

    /**
     * 历史记录
     * @param historical
     * @return
     */
    int setHistorical(Historical historical);

    // 获取课程节问答
    Question[] getSectionQuestion(int id);

    // 获取课程节评论
    Comment[] getSectionComment(int id);

    // 获取课程节笔记
    CourseNotes[] getSectionNotes(int id);

    //  插入课程节的问答
    int setSectionQuestion(Question ques);

    // 插入课程节的笔记
    int setSectionNotes(Notes notes);

    // 插入节的评论
    int setSectionComment(Comment com);

    // 获取ch-notes-son的详细内容,传入笔记id
    CourseNotes getNotesSon(int id);

    // 获取ch-notes-son的课程详细内容,传入课程id
    Detail getNoteSonCourse(int id);

    // 获取ch-question-son 的问题详细内容,传入question.id
    QuestionSon getQuestionSon(int id);

    // 获取ch-question-son 的回答详细内容,传入questionId
    Answer[] getQuestionSonAnswer(int id);

    // 插入ch-question-son 的回答详细内容
    int setQuestionSonAnswer(Answer answer);
}
