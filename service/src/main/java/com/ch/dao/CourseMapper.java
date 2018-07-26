package com.ch.dao;

import com.ch.models.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CourseMapper {

    //    首页推荐的课程信息
    @Select("select * from course")
    Course[] getCourse();

    // 获取课程学习视频
    @Select("select c.chapter,s.section,s.name,s.video from sections s,chapters c where s.chapterId=c.id and s.id=#{id}")
    CourseLearn getCourseLearn(int id);

    // 获取课程节的问题
    @Select("select u.picture img,q.* from question q,user u where q.userId=u.id and q.sectionId=#{id}")
    Question[] getQuestion(int id);
    // 获取课程节的回答
    @Select("select u.picture img,u.name,a.* from user u,answer a where a.userId=u.id and isEyes=1 and a.questionId=#{id}")
    Answer[] getAnswer(int id);

    // 获取课程节的评论
    @Select("select u.picture img,u.name,d.* from user u,discuss d where d.userId=u.id and d.sectionId=#{id}")
    Comment[] getSectionComment(int id);

    @Select("select u.picture img,u.name,n.* from notes n,user u where u.id=n.userId and n.sectionId=#{id}")
    CourseNotes[] getSectionNotes(int id);

}
