package com.ch.service;

import com.ch.models.Course;

public interface SelectionService {

    // 获得方向
    String[] getDirection();

    // 获得分类
    String[] getClassify(int id);

    // 1.选择页面的 全部，全部，全部
    Course[] getSelectionSon();

    // 2.选择页面的 ！全部，全部，全部
    Course[] getCourseTwo(String dir);

    // 3.选择页面的 ！全部，！全部，全部
    Course[] getDifficulty(String directionSon, String classify);

    // 4.选择页面的 ！全部，！全部，！全部
    Course[] getNotall(String directionSon, String classify, String difficultySon);

    // 5.选择页面的 全部，全部，！全部
    Course[] getCourseFive(String diff);

    // 6.选择页面的 ！全部，全部，！全部
    Course[] getCourseSix(String dir, String diff);
}
