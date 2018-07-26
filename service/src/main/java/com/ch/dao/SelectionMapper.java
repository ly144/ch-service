package com.ch.dao;

import com.ch.models.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SelectionMapper {

    // selection中方向和分类的选择
    @Select("select name from direction")
    String[] getDirection();

    @Select("select name from type where directionId = #{id}")
    String[] getClassify(int id);

    // 1.选择页面的 全部，全部，全部
    @Select("select * from course")
    Course[] getSelectionSon();

    // 2.选择页面的 ！全部，全部，全部
    @Select("select course.* from course,type,direction where course.typeId=type.id and type.directionId=direction.id and  direction.name=#{dir}")
    Course[] getCourseTwo(String dir);

    // 3.选择页面的 ！全部，！全部，全部
    @Select("select * from course where course.typeId = (select type.id from type,direction where type.directionId = direction.id and direction.name = #{dir} and type.name = #{classify})")
    Course[] getDifficulty(@Param("dir") String dir, @Param("classify") String classify);

    // 4.选择页面的 ！全部，！全部，！全部
    @Select("select course.* from course,type,direction where course.typeId=type.id and type.directionId=direction.id and direction.name=#{dir} and type.name=#{classify} and course.difficulty =#{diff}")
    Course[] getNotall(@Param("dir") String dir, @Param("classify") String classify, @Param("diff") String diff);

    // 5.选择页面的 全部，全部，！全部
    @Select("select * from  course where difficulty=#{diff}")
    Course[] getCourseFive(String diff);

    // 6.选择页面的 ！全部，全部，！全部
    @Select("select course.* from course,type,direction where course.typeId=type.id and type.directionId=direction.id and  direction.name=#{dir} and course.difficulty=#{diff}")
    Course[] getCourseSix(@Param("dir") String dir, @Param("diff") String diff);
}
