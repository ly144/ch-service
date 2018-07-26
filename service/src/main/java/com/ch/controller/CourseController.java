package com.ch.controller;

import com.ch.models.*;
import com.ch.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    // 获得首页推荐课程详细信息
    @GetMapping("/getCourse")
    public Course[] getCourse() {
        return this.courseService.getCourse();
    }

    /**
     * 获取课程学习视频
     * @param id
     * @return CourseLearn
     */
    @PostMapping("/getCourseLearn")
    CourseLearn getCourseLearn(@RequestBody int id) {
        System.out.println("getCourseLearn" + id);
        return this.courseService.getCourseLearn(id);
    }

    /**
     * 获取课程节的问答
     * @param id
     * @return
     */
    @PostMapping("/getSectionQuestion")
    Question[] getSectionQuestion(@RequestBody int id) {
        System.out.println("getSectionQuestion:" + id);
        return this.courseService.getSectionQuestion(id);
    }

    /**
     * 获取课程节的评论
     * @param id
     * @return
     */
    @PostMapping("/getSectionComment")
    Comment[] getSectionComment(@RequestBody int id) {
        System.out.println("getSectionComment" + id);
        return this.courseService.getSectionComment(id);
    }

    /**
     * 获取课程节的笔记
     * @param id
     * @return
     */
    @PostMapping("/getSectionNotes")
    CourseNotes[] getSectionNotes(@RequestBody int id) {
        System.out.println("getSectionNotes" + id);
        return this.courseService.getSectionNotes(id);
    }

}
