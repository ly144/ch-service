package com.ch.service.serviceImpl;

import com.ch.dao.CourseMapper;
import com.ch.models.*;
import com.ch.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    // 获得首页推荐课程详细信息
    @Override
    public Course[] getCourse(){
        return this.courseMapper.getCourse();
    }

    /**
     * 获取课程学习视频
     * @param id
     * @return
     */
    @Override
    public CourseLearn getCourseLearn(int id) {
        return this.courseMapper.getCourseLearn(id);
    }

    /**
     * 获取课程节的问答
     * @param id
     * @return
     */
    @Override
    public Question[] getSectionQuestion(int id) {
        Question[] qs = this.courseMapper.getQuestion(id);
        for (Question q : qs) {
            Answer[] a = this.courseMapper.getAnswer(q.getId());
            q.setAnswer(a);
        }
        return qs;
    }

    @Override
    public Comment[] getSectionComment(int id) {
        return this.courseMapper.getSectionComment(id);
    }

    @Override
    public CourseNotes[] getSectionNotes(int id) {
        return this.courseMapper.getSectionNotes(id);
    }
}
