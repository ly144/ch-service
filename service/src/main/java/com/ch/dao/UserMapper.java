package com.ch.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user(id, name, password) values(#{id},#{name},#{password})")
    int add(User user);

    @Select("select * from user where name = #{name}")
    User[] getUserByName(String name);

}
