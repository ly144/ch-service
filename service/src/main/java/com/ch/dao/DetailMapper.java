package com.ch.dao;

import com.ch.models.Chapter;
import com.ch.models.CourseChapter;
import com.ch.models.Detail;
import com.ch.models.Sections;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DetailMapper {

    // 获取课程详细页面的课程信息，教师信息，学生信息
    @Select("SELECT direction.name direction,type.name classify,course.* ,user.picture authorImg,user.name authorName,user.job authorJob,usercourse.learned,usercourse.learnTime,usercourse.learnProgress " +
            "from direction,type,course,user,usercourse where course.id=#{courseId} and course.userId=user.id and usercourse.courseId=course.id and usercourse.userId=#{userId} and " +
            "course.typeId=type.id and type.directionId=direction.id")
    Detail getDetail(@Param("courseId") int courseId, @Param("userId") int userId);

    // 获得课程详细页面子页面的课程章节页面的章信息和节信息
    // 1.获得课程中的简介
    @Select("select course.intro from course where course.id=#{id}")
    CourseChapter getIntro(int id);

    // 2.获得章信息
    @Select("select chapters.* from chapters where chapters.courseId=#{id}")
    Chapter[] getChapters(int id);

    // 3.获得节信息
    @Select("select sections.* from sections where sections.chapterId=#{id}")
    Sections[] getSections(int id);

    // 4.获得已学，学一半和新学的节信息
    @Select("select usercourse.learnedSection,usercourse.learningHalf,usercourse.newLearn from usercourse where usercourse.courseId=#{id}")
    Sections getSectionLearn(int id);
}
