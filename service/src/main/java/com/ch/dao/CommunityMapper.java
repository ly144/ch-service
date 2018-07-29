package com.ch.dao;

import com.ch.models.Answer;
import com.ch.models.Community;
import com.ch.models.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CommunityMapper {

    // 猿问社区信息，分类名，分类图片
    @Select("select community.*,type.img,type.name classify,user.name from community,type,user where community.typeId=type.id and community.userId=user.id")
    Community[] getCommunity();

    // 猿问回答信息
    @Select("select answer.*,user.name,user.picture img from answer,user where answer.communityId=#{id} and answer.userId=user.id and answer.isEyes=1")
    Answer[] getAnswer(int id);

    // 猿问登录用户头像，用户名
    @Select("select user.picture,user.name from user where user.id=#{id}")
    User getUserpic(int id);

    // 获取猿问问题详细页面提问者信息
    @Select("select community.*,type.name classify,user.picture quesImg,user.name quesName from community,type,user where community.typeId=type.id and community.userId=user.id and community.id=#{id}")
    Community getApeCommunity(int id);

    // 获取猿问问题详细页面回答内容
    @Select("select answer.*,user.name,user.picture img from answer,user where answer.communityId=#{id} and answer.userId=user.id")
    Answer[] getApeAnswer(int id);

    // ch-ape-quiz获取分类信息
    @Select("select type.name from type where type.id!=0")
    String[] getClassify();

    // ch-ape-quiz插入提问信息
    @Insert("insert into community(userId,typeId,title,content,time) values (#{quiz.userId},#{quiz.typeId},#{quiz.title},#{quiz.content},#{quiz.time} )")
    int setCommunity(@Param("quiz")Community quiz);
}
