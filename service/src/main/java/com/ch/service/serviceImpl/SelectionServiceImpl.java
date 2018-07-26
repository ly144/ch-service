package com.ch.service.serviceImpl;

import com.ch.dao.SelectionMapper;
import com.ch.models.Course;
import com.ch.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectionServiceImpl implements SelectionService {

    @Autowired
    SelectionMapper selectionMapper;

    // 获得方向
    @Override
    public String[] getDirection() {
        return this.selectionMapper.getDirection();
    }

    // 获得分类
    @Override
    public String[] getClassify(int id) {
        return this.selectionMapper.getClassify(id);
    }

    // 1.选择页面的 全部，全部，全部
    @Override
    public Course[] getSelectionSon() {
        return this.selectionMapper.getSelectionSon();
    }

    // 2.选择页面的 ！全部，全部，全部
    @Override
    public Course[] getCourseTwo(String dir){
        return this.selectionMapper.getCourseTwo(dir);
    }

    // 3.选择页面的 ！全部，！全部，全部
    @Override
    public Course[] getDifficulty(String directionSon, String classify) {
        return this.selectionMapper.getDifficulty(directionSon, classify);
    }

    // 4.选择页面的 ！全部，！全部，！全部
    @Override
    public Course[] getNotall(String dir, String classify, String diff){
        return this.selectionMapper.getNotall(dir, classify, diff);
    }

    // 5.选择页面的 全部，全部，！全部
    @Override
    public Course[] getCourseFive(String diff){
        return this.selectionMapper.getCourseFive(diff);
    }

    // 6.选择页面的 ！全部，全部，！全部
    @Override
    public Course[] getCourseSix(String dir, String diff) {
        return this.selectionMapper.getCourseSix(dir,diff);
    }
}
