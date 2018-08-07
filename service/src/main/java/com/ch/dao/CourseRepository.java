package com.ch.dao;

import com.ch.models.Course;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseRepository extends ElasticsearchRepository<Course, Integer> {

    /**
     * 根据课程名模糊查询
     * @param name
     * @return
     */
    public List<Course> findByNameLike(String name);

    /**
     * 根据课程难度查询
     */
    public List<Course> findByDifficulty(String difficulty);

    /**
     * 根据课程分类查询
     * @param typeId
     * @return
     */
    public List<Course> findByTypeId(int typeId);

}
