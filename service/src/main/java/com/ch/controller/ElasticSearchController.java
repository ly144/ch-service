package com.ch.controller;

import com.ch.dao.ApeRepository;
import com.ch.dao.CourseRepository;
import com.ch.dao.FindMapper;
import com.ch.models.Community;
import com.ch.models.Course;
import com.ch.service.CommunityService;
import com.ch.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    CourseService courseService;
    FindMapper findMapper;
    CourseRepository courseRepository;
    ApeRepository apeRepository;
    CommunityService communityService;

    @Autowired
    public ElasticSearchController(CourseService courseService, FindMapper findMapper, CourseRepository courseRepository, ApeRepository apeRepository, CommunityService communityService) {
        this.courseService = courseService;
        this.findMapper = findMapper;
        this.courseRepository = courseRepository;
        this.apeRepository = apeRepository;
        this.communityService = communityService;
    }

    @RequestMapping("/courseInit")
    public boolean courseInit() {
        Course[] courses = this.courseService.getCourse();
        for (Course course : courses) {
            System.out.println(course);
            this.courseRepository.save(course);
        }
        return true;
    }

    @RequestMapping("/communityInit")
    public boolean communityInit() {
        Community[] communities = this.communityService.getCommunity();
        for (Community community : communities) {
            System.out.println(community);
            this.apeRepository.save(community);
        }
        return true;
    }

    @PostMapping("/findCommunity")
    public List<Community> findCommunity(@RequestBody int typeId) {
        if (typeId == 0) {
            Iterable<Community> iterable = this.apeRepository.findAll();
            Iterator<Community> iterator = iterable.iterator();
            List<Community> list = new ArrayList<Community>();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            return list;
        } else {
            return this.apeRepository.findByTypeId(typeId);
        }
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
