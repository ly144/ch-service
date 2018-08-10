package com.ch.service.serviceImpl;

import com.ch.dao.BackstageMapper;
import com.ch.dao.CourseRepository;
import com.ch.models.Chapter;
import com.ch.models.Course;
import com.ch.models.CourseChapter;
import com.ch.models.Sections;
import com.ch.service.BackstageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackstageServiceImpl implements BackstageService {

    @Autowired
    BackstageMapper backstageMapper;
    @Autowired
    CourseRepository courseRepository;

    /**
     * 获取讲师课程
     * @param userId
     * @return
     */
    @Override
    public CourseChapter[] getCourses(int userId) {
        CourseChapter[] ccs = this.backstageMapper.getCourses(userId);
        for (CourseChapter cc : ccs) {
            Chapter[] cs = this.backstageMapper.getChapters(cc.getId());
            cc.setChapters(cs);
            for (Chapter c : cs) {
                c.setSections(this.backstageMapper.getSections(c.getId()));
            }
        }
        return ccs;
    }

    /**
     * 根据课程id获取课程
     * @param id
     * @return
     */
    @Override
    public Course getCourse(int id) {
        return this.backstageMapper.getCourse(id);
    }

    /**
     * 插入课程
     * @param course
     * @return
     */
    @Override
    public int setCourse(Course course) {
        int top = this.backstageMapper.setCourse(course);
        if (top > 0) {
            Course c = this.backstageMapper.getCourseOfName(course.getName());
            this.courseRepository.save(c);
        }
        return top;
    }

    /**
     * 插入章
     * @param chapter
     * @return
     */
    @Override
    public int setChapter(Chapter chapter) {
        return this.backstageMapper.setChapter(chapter);
    }

    /**
     * 插入节
     * @param sections
     * @return
     */
    @Override
    public int setSection(Sections sections) {
        return this.backstageMapper.setSection(sections);
    }

    /**
     * 删除课程
     * @param id
     * @return
     */
    @Override
    public int deleteCourse(int id) {
        int[] ch = this.backstageMapper.selectDeleteCourse(id);
        for (int c : ch) {
            this.backstageMapper.deleteCourseSection(c);
        }
        this.backstageMapper.deleteCourseChapter(id);
        this.courseRepository.delete(id);
        return this.backstageMapper.deleteCourse(id);
    }

    /**
     * 删除章
     * @param id
     * @return
     */
    @Override
    public int deleteChapter(int id) {
        this.backstageMapper.deleteCourseSection(id);
        return this.backstageMapper.deleteChapter(id);
    }

    /**
     * 删除节
     * @param id
     * @return
     */
    @Override
    public int deleteSection(int id) {
        return this.backstageMapper.deleteSection(id);
    }

    @Override
    public int changeCourse(Course course) {
        this.courseRepository.save(course);
        return this.backstageMapper.changeCourse(course);
    }

    @Override
    public int changeChapter(Chapter chapter) {
        return this.backstageMapper.changeChapter(chapter);
    }

    @Override
    public int changeSection(Sections section) {
        return this.backstageMapper.changeSection(section);
    }
}
