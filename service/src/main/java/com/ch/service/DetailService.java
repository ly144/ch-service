package com.ch.service;

import com.ch.models.*;

public interface DetailService {

    // 获取课程详细页面的课程信息，教师信息，学生信息
    Detail getDetail(int courseId, int userId);

    // 获得课程详细页面子页面的课程章节页面的章信息和节信息
    CourseChapter getCourseChapter(int id);

    // 获取课程问答
    Question[] getCourseQuestion(int id);
    // 获取课程评论
    Comment[] getCourseComment(int id);
    // 获取课程笔记
    CourseNotes[] getCourseNotes(int id);
}
