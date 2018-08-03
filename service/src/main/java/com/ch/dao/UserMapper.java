package com.ch.dao;

import com.ch.models.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,password,phone) values(#{user.username},#{user.password},#{user.phone})")
    int regis(@Param("user")UserLogin user);

    @Select("select * from user where name = #{name}")
    User getUserByName(String name);

    @Select("select name,picture,sex,signature,learnTime,attentionNum,phone,email,job,address from user where name = #{name}")
    Person getPerson(String name);

    @Select("select uc.time,c.img,c.name,uc.learned,uc.learnTime,uc.learnProgress,uc.notesNum,uc.questionNum from usercourse uc,course c where uc.courseId=c.id and uc.userId=#{id}")
    PersonCourse[] getPersonCourse(int id);

    @Select("select t.name,q.title,q.time,q.answerNum from community q,type t where q.typeId=t.id and q.userId=#{id}")
    Ape[] getPersonApeQuiz(int id);

    @Select("select t.name,q.title,a.content,a.time,a.answerNum from answer a,community q,type t where a.communityId=q.id and q.typeId=t.id and a.userId=#{id}")
    Ape[] getPersonApeAnswer(int id);

    @Select("select t.name,q.title,q.time,q.answerNum from userattention ua,community q,type t where ua.otherId=q.id and q.typeId=t.id and ua.userId=#{id}")
    Ape[] getPersonApeAttention(int id);

    @Select("select c.name courseName,ch.chapter,s.section,s.name sectionName,n.content,n.agreeNum,n.gatherNum,n.time from notes n,sections s,chapters ch,course c where n.sectionId=s.id and s.chapterId=ch.id and ch.courseId=c.id and n.userId=#{id}")
    Notes[] getNotes(int id);
}