package com.ch.dao;

import com.ch.models.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CourseMapper {

    //    首页推荐的课程信息
    @Select("select * from course")
    Course[] getCourse();

    // 获取课程学习视频
    @Select("select c.courseId,c.chapter,s.section,s.name,s.video from sections s,chapters c where s.chapterId=c.id and s.id=#{id}")
    CourseLearn getCourseLearn(int id);

    /**
     * 查找用户历史记录
     * @param courseId
     * @param userId
     * @return int
     */
    @Select("select * from usercourse uc where courseId=#{courseId} and userId=#{userId}")
    Historical getUserHistorical(@Param("courseId") int courseId, @Param("userId") int userId);

    /**
     * 若没有历史记录，则插入
     * @param historical
     * @return int
     */
    @Insert("insert into usercourse(courseId,userId,time,learned,learnTime,learnProgress,notesNum,questionNum,statue,learnedSection,learningHalf,newLearn) " +
            "values(#{his.courseId},#{his.userId},#{his.time},#{his.learned},#{his.learnTime},#{his.learnProgress},#{his.notesNum},#{his.questionNum},#{his.statue},#{his.learnedSection},#{his.learningHalf},#{his.newLearn})")
    int setUserHistorical(@Param("his") Historical historical);

    /**
     * 若有历史记录，则修改
     * @param historical
     * @return int
     */
    @Update("update usercourse set courseId=#{his.courseId},userId=#{his.userId},time=#{his.time},learned=#{his.learned},learnTime=#{his.learnTime},learnProgress=#{his.learnProgress},notesNum=#{his.notesNum},questionNum=#{his.questionNum},statue=#{his.statue},learnedSection=#{his.learnedSection},learningHalf=#{his.learningHalf},newLearn=#{his.newLearn} where id=#{his.id}")
    int changeUserHistorical(@Param("his") Historical historical);

    // 获取课程节的问题
    @Select("select u.picture img,q.* from question q,user u where q.userId=u.id and q.sectionId=#{id}")
    Question[] getQuestion(int id);
    // 获取课程节的回答
    @Select("select u.picture img,u.name,a.* from user u,answer a where a.userId=u.id and isEyes=1 and a.questionId=#{id}")
    Answer[] getAnswer(int id);

    // 获取课程节的评论
    @Select("select u.picture img,u.name,d.* from user u,discuss d where d.userId=u.id and d.sectionId=#{id}")
    Comment[] getSectionComment(int id);

    // 获取课程节的笔记
    @Select("select u.picture img,u.name,n.* from notes n,user u where u.id=n.userId and n.sectionId=#{id}")
    CourseNotes[] getSectionNotes(int id);

    //  插入课程节的问答
    @Insert("INSERT into question(userId,sectionId,title,content,time) VALUES( #{ques.userId},#{ques.sectionId},#{ques.title},#{ques.content},#{ques.time} )")
    int  setSectionQuestion(@Param("ques") Question ques);

    // 插入课程节的笔记
    @Insert("INSERT into notes(userId,sectionId,content,time) VALUES(#{notes.userId},#{notes.sectionId},#{notes.content},#{notes.time} )")
    int setSectionNotes(@Param("notes") Notes notes);

    // 插入节的评论
    @Insert("INSERT into discuss(userId,sectionId,content,time) VALUES(#{com.userId},#{com.sectionId},#{com.content},#{com.time})")
    int setSectionComment(@Param("com") Comment com);

    // 获取ch-notes-son的详细内容,传入笔记id
    @Select("select notes.*,user.name,user.picture img,chapters.chapter,sections.section,sections.name sectionName from notes,user,chapters,sections where notes.id=#{id} and notes.userId=user.id and notes.sectionId=sections.id and sections.chapterId=chapters.id")
    CourseNotes getNotesSon(int id);

    // 获取ch-notes-son的课程详细内容,传入课程id
    @Select("select course.*,u.picture authorImg,u.name authorName,u.job authorJob,u.signature from course,user u where course.id=#{id} and course.userId=u.id")
    Detail getNoteSonCourse(int id);

    // 获取ch-question-son 的问题详细内容,传入question.id
    @Select("select d.name directions,t.name classify,c.name courseName,q.*,u.name,u.picture,ch.chapter,s.section from direction d,type t,course c,question q,user u,chapters ch,sections s where q.id=#{id} and q.userId=u.id and q.sectionId=s.id and s.chapterId=ch.id and ch.courseId=c.id and c.typeId=t.id and t.directionId=d.id")
    QuestionSon getQuestionSon(int id);

    // 获取ch-question-son 的回答详细内容,传入questionId
    @Select("select user.name,user.picture img,answer.* from user,answer where answer.questionId=#{id} and answer.userId=user.id")
    Answer[] getQuestionSonAnswer(int id);

    // 插入ch-question-son 的回答详细内容
    @Insert("INSERT into answer(userId,questionId,content,time) VALUES (#{answer.userId},#{answer.questionId},#{answer.content},#{answer.time})")
    int setQuestionSonAnswer(@Param("answer") Answer answer);
}
