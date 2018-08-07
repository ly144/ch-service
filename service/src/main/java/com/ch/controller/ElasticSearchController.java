package com.ch.controller;

import com.ch.dao.CourseRepository;
import com.ch.dao.FindMapper;
import com.ch.models.Course;
import com.ch.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    @Autowired
    CourseService courseService;

    @Autowired
    FindMapper findMapper;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/init")
    public boolean init() {
        Course[] courses = this.courseService.getCourse();
        for (Course course : courses) {
            System.out.println(course);
            this.courseRepository.save(course);
        }
        return true;
    }

    @PostMapping("/findCourse")
    public List<Course> findCourse(@RequestBody String value) {
        System.out.println(value);
        List<Course> courses = new ArrayList<>();
        Course course;
        if (this.courseRepository.findByNameLike(value).size() != 0) {
            Iterator<Course> iterator = this.courseRepository.findByNameLike(value).iterator();
            while (iterator.hasNext()) {
                course = iterator.next();
                if (courses.indexOf(course) == -1)
                    courses.add(course);
            }
        }

        if (this.courseRepository.findByDifficulty(value).size() != 0) {
            Iterator<Course> iterator = this.courseRepository.findByDifficulty(value).iterator();
            while (iterator.hasNext()) {
                course = iterator.next();
                if (courses.indexOf(course) == -1)
                    courses.add(course);
            }
        }
        int[] typeIds = null;
        if ( ((typeIds = this.findMapper.selectTypeId(value)) != null) ) {
            for (int typeId : typeIds) {
                System.out.println(typeId);
                if (this.courseRepository.findByTypeId(typeId).size() != 0) {
                    Iterator<Course> iterator = this.courseRepository.findByTypeId(typeId).iterator();
                    while (iterator.hasNext()) {
                        course = iterator.next();
                        if (courses.indexOf(course) == -1)
                            courses.add(course);
                    }
                }
            }
        }
        int[] directionIds = null;
        if ((directionIds = this.findMapper.selectDirectionId(value)) != null ) {
            for (int directionId : directionIds) {
                if ( ((typeIds = this.findMapper.selectTypeIdOfDirId(directionId)) != null) ) {
                    for (int typeId : typeIds) {
                        if (this.courseRepository.findByTypeId(typeId).size() != 0) {
                            Iterator<Course> iterator = this.courseRepository.findByTypeId(typeId).iterator();
                            while (iterator.hasNext()) {
                                course = iterator.next();
                                if (courses.indexOf(course) == -1)
                                    courses.add(course);
                            }
                        }
                    }
                }
            }
        }

        for (Course course1 : courses) {
            System.out.println(course1);
        }
        return courses;
    }


}
