package com.ch.controller;

import com.ch.models.CourseChapter;
import com.ch.models.Detail;
import com.ch.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //获取课程章节信息
    @PostMapping("/getChapterSection")
    public CourseChapter getChapterSection(@RequestBody int id) {
        return this.detailService.getCourseChapter(id);
    }
}
