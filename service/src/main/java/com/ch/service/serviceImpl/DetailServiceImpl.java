package com.ch.service.serviceImpl;

import com.ch.dao.DetailMapper;
import com.ch.models.*;
import com.ch.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DetailServiceImpl implements DetailService{

    @Autowired
    DetailMapper detailMapper;

    // 获取课程详细页面的课程信息，教师信息，学生信息
    @Override
    public Detail getDetail(int courseId, int userId) {
        return this.detailMapper.getDetail(courseId, userId);
    }

    // 获得课程详细页面子页面的课程章节页面的章信息和节信息
    @Override
    public CourseChapter getCourseChapter(int id) {
        CourseChapter cc = this.detailMapper.getIntro(id);
        cc.setChapters(this.detailMapper.getChapters(id));

        Sections sl = this.detailMapper.getSectionLearn(id);
        System.out.println(sl.getLearnedSection()+sl.getLearningHalf()+sl.getNewLearn());

        int nl = sl.getNewLearn();

        String learnedSection = sl.getLearnedSection();
        String[] ls = learnedSection.split(",");
        ArrayList<Integer> lss = new ArrayList<>();
        for(int i=0; i<ls.length; i++) {
            lss.add(Integer.parseInt(ls[i]));
        }

        String learningHalf = sl.getLearningHalf();
        String[] lh = learningHalf.split(",");
        ArrayList<Integer> lhs = new ArrayList<>();
        for(int i=0; i<lh.length; i++) {
            lhs.add(Integer.parseInt(lh[i]));
        }

        for (Chapter c : cc.getChapters()) {
            Sections[] sections = this.detailMapper.getSections(c.getId());
            c.setSections(sections);
            for (Sections section : sections) {
                section.setNewLearn(nl);
                int sectionId = section.getId();
                if (lss.indexOf(sectionId) >= 0) {
                    section.setLearnedSections(1);
                } else {
                    section.setLearnedSections(0);
                }
                if (lhs.indexOf(sectionId) >= 0) {
                    section.setLearningHalfs(1);
                } else {
                    section.setLearningHalfs(0);
                }
            }
        }
        return cc;
    }

    /**
     * 获取课程的问答
     * @param id
     * @return
     */
    @Override
    public Question[] getCourseQuestion(int id) {
        Question[] qs = this.detailMapper.getQuestion(id);
        for (Question q : qs) {
            Answer[] a = this.detailMapper.getAnswer(q.getId());
            q.setAnswer(a);
        }
        return qs;
    }

    /**
     * 获取课程的评论
     * @param id
     * @return
     */
    @Override
    public Comment[] getCourseComment(int id) {
        return this.detailMapper.getCourseComment(id);
    }

    /**
     * 获取课程的笔记
     * @param id
     * @return
     */
    @Override
    public CourseNotes[] getCourseNotes(int id) {
        return this.detailMapper.getCourseNotes(id);
    }

}
