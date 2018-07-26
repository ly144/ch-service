package com.ch.service;

import com.ch.models.*;

public interface CourseService {
    // 获得首页推荐课程详细信息
    Course[] getCourse();
    CourseLearn getCourseLearn(int id);
    Question[] getSectionQuestion(int id);
    Comment[] getSectionComment(int id);
    CourseNotes[] getSectionNotes(int id);
}
