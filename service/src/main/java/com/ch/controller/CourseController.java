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

    //  插入课程节的问答
    @PostMapping("/setSectionQuestion")
    int setSectionQuestion(@RequestBody Question ques) {
        return this.courseService.setSectionQuestion(ques);
    }

    // 插入课程节的笔记
    @PostMapping("/setSectionNotes")
    int setSectionNotes(@RequestBody Notes notes) {
        return this.courseService.setSectionNotes(notes);
    }

    // 插入节的评论
    @PostMapping("/setSectionComment")
    int setSectionComment(@RequestBody Comment com) {
        return this.courseService.setSectionComment(com);
    }

    // 获取ch-notes-son的笔记详细内容,传入笔记id
    @PostMapping("/getNotesSon")
    CourseNotes getNotesSon(@RequestBody int id) {
        System.out.println("获取ch-notes-son的笔记详细内容");
        return this.courseService.getNotesSon(id);
    }

    // 获取ch-notes-son的课程详细内容,传入课程id
    @PostMapping("/getNoteSonCourse")
    Detail getNoteSonCourse(@RequestBody int id) {
        System.out.println("获取ch-notes-son的课程详细内容");
        return this.courseService.getNoteSonCourse(id);
    }


    // 获取ch-question-son 的问题详细内容,传入question.id
    @PostMapping("/getQuestionSon")
    QuestionSon getQuestionSon(@RequestBody int id) {
        System.out.println("获取ch-question-son 的问题详细内容");
        return this.courseService.getQuestionSon(id);
    }

    // 获取ch-question-son 的回答详细内容,传入questionId
    @PostMapping("/getQuestionSonAnswer")
    Answer[] getQuestionSonAnswer(@RequestBody int id) {
        System.out.println("获取ch-question-son 的回答详细内容");
        return this.courseService.getQuestionSonAnswer(id);
    }

    // 插入ch-question-son 的回答详细内容
    @PostMapping("/setQuestionSonAnswer")
    int setQuestionSonAnswer(@RequestBody Answer answer){
        System.out.println("插入ch-question-son 的回答详细内容");
        return this.courseService.setQuestionSonAnswer(answer);
    }
}
