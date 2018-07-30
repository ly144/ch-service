package com.ch.controller;

import com.ch.models.Chapter;
import com.ch.models.Course;
import com.ch.models.CourseChapter;
import com.ch.models.Sections;
import com.ch.service.BackstageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/backstage")
public class BackstageController {

    @Autowired
    BackstageService backstageService;

    @PostMapping("/getCourses")
    CourseChapter[] getCourses(@RequestBody int userId) {
        return this.backstageService.getCourses(userId);
    }

    @PostMapping("/getCourse")
    Course getCourse(@RequestBody int Id) {
        return this.backstageService.getCourse(Id);
    }

    @PostMapping("/setCourse")
    int setCourse(@RequestBody Course course) {
        return this.backstageService.setCourse(course);
    }

    @PostMapping("/setChapter")
    int setChapter(@RequestBody Chapter chapter) {
        return this.backstageService.setChapter(chapter);
    }

    @PostMapping("/setSection")
    int setSection(@RequestBody Sections section) {
        return this.backstageService.setSection(section);
    }

    @PostMapping("/deleteCourse")
    int deleteCourse(@RequestBody int courseId) {
        return this.backstageService.deleteCourse(courseId);
    }

    @PostMapping("/deleteChapter")
    int deleteChapter(@RequestBody int chapterId) {
        return this.backstageService.deleteChapter(chapterId);
    }

    @PostMapping("/deleteSection")
    int deleteSection(@RequestBody int sectionId) {
        return this.backstageService.deleteSection(sectionId);
    }

    @PostMapping("/changeCourse")
    int changeCourse(@RequestBody Course course) {
        return this.backstageService.changeCourse(course);
    }

    @PostMapping("/changeChapter")
    int changeChapter(@RequestBody Chapter chapter) {
        return this.backstageService.changeChapter(chapter);
    }

    @PostMapping("/changeSection")
    int changeSection(@RequestBody Sections section) {
        return this.backstageService.changeSection(section);
    }

}
