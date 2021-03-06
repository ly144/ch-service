package com.ch.dao;

import com.ch.models.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DetailMapper {

    // 获取课程详细页面的课程信息，教师信息，学生信息
    @Select("SELECT direction.name direction,type.name classify,course.*,user.picture authorImg,user.name authorName,user.job authorJob " +
            "from direction,type,course,user where course.id=#{courseId} and course.userId=user.id and course.typeId=type.id and type.directionId=direction.id")
    Detail getDetail(int courseId);

    // 获取课程的用户学习情况
    @Select("select uc.learned,uc.learnTime,uc.learnProgress,uc.newLearn sectionId from usercourse uc where uc.courseId=#{courseId} and uc.userId=#{userId}")
    Detail getDetailLearn(@Param("courseId") int courseId, @Param("userId") int userId);

    // 获取课程第一节
    @Select("select s.id from sections s,chapters c where s.chapterId=c.id and c.courseId=#{courseId}")
    int[] getSectionId(int courseId);



    // 获得课程详细页面子页面的课程章节页面的章信息和节信息
    // 1.获得课程中的简介
    @Select("select course.* from course where course.id=#{id}")
    CourseChapter getIntro(int id);
    // 2.获得章信息
    @Select("select chapters.* from chapters where chapters.courseId=#{id}")
    Chapter[] getChapters(int id);
    // 3.获得节信息
    @Select("select sections.* from sections where sections.chapterId=#{id}")
    Sections[] getSections(int id);
    // 4.获得已学，学一半和新学的节信息
    @Select("select uc.learnedSection,uc.learningHalf,uc.newLearn from usercourse uc where uc.courseId=#{courseId} and uc.userId=#{userId}")
    CourseChapter getSectionLearn(@Param("courseId") int courseId, @Param("userId") int userId);


    // 获取课程的问题
    @Select("select u.picture img,q.*,ch.chapter,s.section,s.name sectionName from question q,user u,sections s,chapters ch,course c where q.userId=u.id and q.sectionId=s.id and s.chapterId=ch.id and ch.courseId=c.id and c.id=#{id}")
    Question[] getQuestion(int id);
    // 获取课程的回答
    @Select("select u.picture img,u.name,a.* from user u,answer a where a.userId=u.id and isEyes=1 and a.questionId=#{id}")
    Answer[] getAnswer(int id);

    // 获取课程的评论
    @Select("select u.picture img,u.name,ch.chapter,s.section,s.name sectionName,d.* from user u,sections s,chapters ch,course c,discuss d where d.userId=u.id and d.sectionId=s.id and s.chapterId=ch.id and ch.courseId=c.id and c.id=#{id}")
    Comment[] getCourseComment(int id);

    // 获取课程的笔记
    @Select("select u.picture img,u.name,ch.chapter,s.section,s.name sectionName,n.* from notes n,sections s,chapters ch,user u,course c where u.id=n.userId and s.chapterId=ch.id and n.sectionId=s.id and ch.courseId=c.id and c.id=#{id}")
    CourseNotes[] getCourseNotes(int id);
}
