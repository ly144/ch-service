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
        Detail detail = this.detailMapper.getDetail(courseId);
        Detail dlearn = this.detailMapper.getDetailLearn(courseId, userId);
        if (dlearn == null) {
            detail.setLearned(0);
            detail.setSectionId(this.detailMapper.getSectionId(courseId)[0]);
        } else {
            detail.setLearned(dlearn.getLearned());
            detail.setLearnTime(dlearn.getLearnTime());
            detail.setLearnProgress(dlearn.getLearnProgress());
            detail.setSectionId(dlearn.getSectionId());
        }
        return detail;
    }

    // 获得课程详细页面子页面的课程章节页面的章信息和节信息
    @Override
    public CourseChapter getCourseChapter(int courseId, int userId) {
        CourseChapter cc = this.detailMapper.getIntro(courseId);
        cc.setChapters(this.detailMapper.getChapters(courseId));

        int nl = 0; // 课程正在学习的课程
        ArrayList<Integer> lss = new ArrayList<>(); // 课程已学习课程
        ArrayList<Integer> lhs = new ArrayList<>(); // 课程学习一半课程
        if (userId > 0) {
            CourseChapter sl = this.detailMapper.getSectionLearn(courseId, userId);
            if (sl != null) {
                System.out.println(sl.getLearnedSection() + "-" + sl.getLearningHalf() + "-" + sl.getNewLearn());

                nl = sl.getNewLearn();
                cc.setNewLearn(nl);

                String learnedSection = sl.getLearnedSection();
                cc.setLearnedSection(learnedSection);
                if (learnedSection != null) {
                    String[] ls = learnedSection.split(",");
                    for (int i = 0; i < ls.length; i++) {
                        lss.add(Integer.parseInt(ls[i]));
                    }
                }

                String learningHalf = sl.getLearningHalf();
                cc.setLearningHalf(learningHalf);
                String[] lh = learningHalf.split(",");
                for (int i = 0; i < lh.length; i++) {
                    lhs.add(Integer.parseInt(lh[i]));
                }
            }
        }


        for (Chapter c : cc.getChapters()) {
            Sections[] sections = this.detailMapper.getSections(c.getId());
            c.setSections(sections);

            for (Sections section : sections) {
                if (userId > 0) {
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
                } else {
                    section.setNewLearn(0);
                    section.setLearnedSections(0);
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
