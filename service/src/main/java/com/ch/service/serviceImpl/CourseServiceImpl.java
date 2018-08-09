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
    public Course[] getCourse() {
        return this.courseMapper.getCourse();
    }

    /**
     * 获取课程学习视频
     *
     * @param id
     * @return
     */
    @Override
    public CourseLearn getCourseLearn(int id) {
        return this.courseMapper.getCourseLearn(id);
    }

    @Override
    public int setHistorical(Historical historical) {
        Historical his = this.courseMapper.getUserHistorical(historical.getCourseId(), historical.getUserId());
        if (his != null) {
            if (historical.getTime() != null) {
                his.setTime(historical.getTime());
            }
            if (historical.getLearned() != 0) {
                his.setLearned(historical.getLearned());
            }
            if (historical.getLearnTime() != null) {
                his.setLearnTime(historical.getLearnTime());
            }
            if (historical.getLearnProgress() != null) {
                his.setLearnProgress(historical.getLearnProgress());
            }
            if (historical.getNotesNum() != 0) {
                his.setNotesNum(historical.getNotesNum());
            }
            if (historical.getQuestionNum() != 0) {
                his.setQuestionNum(historical.getQuestionNum());
            }
            if (historical.getStatue() != 0) {
                his.setStatue(historical.getStatue());
            }
            if (historical.getLearnedSection() != null) {
                his.setLearnedSection(historical.getLearnedSection());
            }
            if (historical.getLearningHalf() != null) {
                his.setLearningHalf(historical.getLearningHalf());
            }
            if (historical.getNewLearn() != 0) {
                his.setNewLearn(historical.getNewLearn());
            }
            return this.courseMapper.changeUserHistorical(his);
        } else {
            return this.courseMapper.setUserHistorical(historical);
        }
    }

    /**
     * 获取课程节的问答
     *
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

    //  插入课程节的问答
    @Override
    public int setSectionQuestion(Question ques) {
        return this.courseMapper.setSectionQuestion(ques);
    }

    // 插入课程节的笔记
    @Override
    public int setSectionNotes(Notes notes) {
        return this.courseMapper.setSectionNotes(notes);
    }

    // 插入节的评论
    @Override
    public int setSectionComment(Comment com) {
        return this.courseMapper.setSectionComment(com);
    }

    // 获取ch-notes-son的详细内容,传入笔记id
    @Override
    public CourseNotes getNotesSon(int id) {
        return this.courseMapper.getNotesSon(id);
    }

    // 获取ch-notes-son的课程详细内容,传入课程id
    @Override
    public Detail getNoteSonCourse(int id) {
        return this.courseMapper.getNoteSonCourse(id);
    }

    // 获取ch-question-son 的问题详细内容,传入question.id
    @Override
    public QuestionSon getQuestionSon(int id) {
        return this.courseMapper.getQuestionSon(id);
    }

    // 获取ch-question-son 的回答详细内容,传入questionId
    @Override
    public Answer[] getQuestionSonAnswer(int id){
        return this.courseMapper.getQuestionSonAnswer(id);
    }

    // 插入ch-question-son 的回答详细内容
    @Override
    public int setQuestionSonAnswer(Answer answer){
        return this.courseMapper.setQuestionSonAnswer(answer);
    }
}
