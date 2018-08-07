package com.ch.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface FindMapper {

    @Select("select id from type where name=#{name}")
    int[] selectTypeId(String name);

    @Select("select id from type where directionId=#{directionId}")
    int[] selectTypeIdOfDirId(int directionId);

    @Select("select id from direction where name=#{name}")
    int[] selectDirectionId(String name);

}
