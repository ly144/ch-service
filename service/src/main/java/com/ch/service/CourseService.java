package com.ch.service;

import com.ch.models.*;

public interface CourseService {
    // 获得首页推荐课程详细信息
    Course[] getCourse();
    // 获取课程学习视频
    CourseLearn getCourseLearn(int id);
    // 获取课程节问答
    Question[] getSectionQuestion(int id);
    // 获取课程节评论
    Comment[] getSectionComment(int id);
    // 获取课程节笔记
    CourseNotes[] getSectionNotes(int id);
}
