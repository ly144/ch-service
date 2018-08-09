package com.ch.controller;

import com.ch.models.*;
import com.ch.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    DetailService detailService;

    // 获取课程详细页面的课程信息，教师信息，学生信息
    @PostMapping("/getCourse")
    public Detail getDetail(@RequestBody int[] passId){
        System.out.println(passId[0] +","+ passId[1]);
        return detailService.getDetail(passId[0], passId[1]);
    }

    /**
     * 获取课程章和节
     * @param id
     * @return
     */
    @PostMapping("/getChapterSection")
    public CourseChapter getChapterSection(@RequestBody int[] id) {
        return this.detailService.getCourseChapter(id[0], id[1]);
    }

    /**
     * 获取课程的问答
     * @param id
     * @return
     */
    @PostMapping("/getCourseQuestion")
    Question[] getCourseQuestion(@RequestBody int id) {
        System.out.println("getCourseQuestion:" + id);
        return this.detailService.getCourseQuestion(id);
    }

    /**
     * 获取课程的评论
     * @param id
     * @return
     */
    @PostMapping("/getCourseComment")
    Comment[] getCourseComment(@RequestBody int id) {
        System.out.println("getCourseComment:" + id);
        return this.detailService.getCourseComment(id);
    }

    /**
     * 获取课程的笔记
     * @param id
     * @return
     */
    @PostMapping("/getCourseNotes")
    CourseNotes[] getCourseNotes(@RequestBody int id) {
        System.out.println("getCourseNotes:" + id);
        return this.detailService.getCourseNotes(id);
    }
}
