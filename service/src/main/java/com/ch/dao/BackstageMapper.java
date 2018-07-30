package com.ch.dao;

import com.ch.models.Chapter;
import com.ch.models.Course;
import com.ch.models.CourseChapter;
import com.ch.models.Sections;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BackstageMapper {


    /**
     * 获取讲师课程1.获取课程
     * @param userId
     * @return
     */
    @Select("select * from course where userId=#{userId}")
    CourseChapter[] getCourses(int userId);
    // 2.获取章
    @Select("select * from chapters where courseId=#{courseId}")
    Chapter[] getChapters(int courseId);
    // 3.获取节
    @Select("select * from sections where chapterId=#{chapterId}")
    Sections[] getSections(int chapterId);

    /**
     * 根据课程id获取课程
     * @param id
     * @return
     */
    @Select("select * from course where id=#{id}")
    Course getCourse(int id);

    /**
     * 插入课程
     * @param course
     * @return
     */
    @Insert("insert into course(typeId,img,name,difficulty,shortIntro,userId,intro,time,uploadTime,know,learnWhat) values (#{course.typeId},#{course.img},#{course.name},#{course.difficulty},#{course.shortIntro},#{course.userId},#{course.intro},#{course.time},#{course.uploadTime},#{course.know},#{course.learnWhat})")
    int setCourse(@Param("course")Course course);

    /**
     * 插入章
     * @param chapter
     * @return
     */
    @Insert("insert into chapters(courseId,chapter,name,summary) values (#{chapter.courseId},#{chapter.chapter},#{chapter.name},#{chapter.summary})")
    int setChapter(@Param("chapter")Chapter chapter);

    /**
     * 插入节
     * @param sections
     * @return
     */
    @Insert("insert into sections(chapterId,section,name) values (#{sec.chapterId},#{sec.section},#{sec.name})")
    int setSection(@Param("sec")Sections sections);

    /**
     * 删除课程
     * @param id
     * @return
     */
    @Delete("delete from course where id=#{id}")
    int deleteCourse(int id);
    @Select("select id from chapters where courseId=#{courseId}")
    int[] selectDeleteCourse(int courseId);
    @Delete("delete from chapters where courseId=#{courseId}")
    int deleteCourseChapter(int courseId);
    @Delete("delete from sections where chapterId=#{chapterId}")
    int deleteCourseSection(int chapterId);

    /**
     * 删除章
     * @param id
     * @return
     */
    @Delete("delete from chapters where id=#{id}")
    int deleteChapter(int id);


    /**
     * 删除节
     * @param id
     * @return
     */
    @Delete("delete from sections where id=#{id}")
    int deleteSection(int id);

    /**
     * 修改课程
     * @param course
     * @return
     */
    @Update("update course set typeId=#{course.typeId},difficulty=#{course.difficulty},name=#{course.name},img=#{course.img},shortIntro=#{course.shortIntro},intro=#{course.intro},know=#{course.know},learnWhat=#{course.learnWhat},time=#{course.time},uploadTime=#{course.uploadTime} where id=#{course.id}")
    int changeCourse(@Param("course")Course course);

    @Update("update chapters set name=#{cha.name},summary=#{cha.summary} where id=#{cha.id}")
    int changeChapter(@Param("cha")Chapter chapter);

    @Update("update sections set name=#{sec.name} where id=#{sec.id}")
    int changeSection(@Param("sec")Sections section);

}
