package com.ch.dao;

import com.ch.models.*;
import com.ch.models.Result;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,password,phone,picture,root) values(#{user.username},#{user.password},#{user.phone},#{user.picture},#{user.root})")
    int regis(@Param("user")UserLogin user);

    @Select("select * from user where name = #{name}")
    User getUserByName(String name);

    @Select("select root,picture from user where id=#{id}")
    Result getPicture(int id);

    @Select("select * from user where id = #{id}")
    Person getPerson(int id);

    @Select("select uc.courseId id,uc.newLearn section,uc.time,c.img,c.name,uc.learned,uc.learnTime,uc.learnProgress,uc.notesNum,uc.questionNum from usercourse uc,course c where uc.courseId=c.id and uc.userId=#{id}")
    PersonCourse[] getPersonCourse(int id);

    @Select("select q.id,t.name,t.img,q.title,q.time,q.answerNum from community q,type t where q.typeId=t.id and q.userId=#{id}")
    Ape[] getPersonApeQuiz(int id);

    @Select("select q.id,t.name,t.img,q.title,a.content,a.time,a.answerNum from answer a,community q,type t where a.communityId=q.id and q.typeId=t.id and a.userId=#{id}")
    Ape[] getPersonApeAnswer(int id);

    @Select("select q.id,t.name,t.img,q.title,q.time,q.answerNum from userattention ua,community q,type t where ua.otherId=q.id and q.typeId=t.id and ua.userId=#{id}")
    Ape[] getPersonApeAttention(int id);

    @Select("select c.id courseId,c.name courseName,ch.chapter,s.id sectionId,s.section,s.name sectionName,n.content,n.agreeNum,n.gatherNum,n.time from notes n,sections s,chapters ch,course c where n.sectionId=s.id and s.chapterId=ch.id and ch.courseId=c.id and n.userId=#{id}")
    Notes[] getNotes(int id);

    @Update("update user set name=#{per.name},picture=#{per.picture},sex=#{per.sex},signature=#{per.signature},job=#{per.job},address=#{per.address} where id=#{per.id}")
    int changePerson(@Param("per")Person person);

    @Update("update user set email=#{email} where id=#{id}")
    int changeEmail(@Param("email") String email, @Param("id") int id);

    @Update("update user set phone=#{phone} where id=#{id}")
    int changePhone(@Param("phone") String phone, @Param("id") int id);

    @Update("update user set password=#{password} where id=#{id}")
    int changePass(@Param("password") String password, @Param("id") int id);

}