package com.ch.service;

import com.ch.models.Chapter;
import com.ch.models.Course;
import com.ch.models.CourseChapter;
import com.ch.models.Sections;

public interface BackstageService {
    CourseChapter[] getCourses(int userId);
    Course getCourse(int id);
    int setCourse(Course course);
    int setChapter(Chapter chapter);
    int setSection(Sections sections);
    int deleteCourse(int id);
    int deleteChapter(int id);
    int deleteSection(int id);
    int changeCourse(Course course);
    int changeChapter(Chapter chapter);
    int changeSection(Sections section);
}
