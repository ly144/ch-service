package com.ch.controller;

import com.ch.models.Course;
import com.ch.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/selection")
public class SelectionController {

    @Autowired
    SelectionService selectionService;

    // 获得方向
    @GetMapping("/getDirection")
    public String[] getDirection() {
        return this.selectionService.getDirection();
    }

    // 获得分类
    @GetMapping("/getClassifyAll")
    public String[][] getClassify() {
        String[][] all = new String[11][];
        all[0] = new String[1];
        all[0][0] = "全部";
        for (int i=1; i<11; i++){
            String[] ss = this.selectionService.getClassify(i);
            int len = ss.length;
            all[i] = new String[len+1];
            all[i][0] = "全部";
            for(int j=0; j<len; j++){
                all[i][j+1] = ss[j];
            }
        }
        return all;
    }

    // 获得选择中的所有课程
    @PostMapping("/getSelectionSon")
    public Course[] getSelectionSon(@RequestBody String[] nowSelect){
        System.out.println(nowSelect[0]);
        System.out.println(nowSelect[1]);
        System.out.println(nowSelect[2]);
        if (nowSelect[0].equals("全部") && nowSelect[1].equals("全部") && nowSelect[2].equals("全部")) { // 1
            return this.selectionService.getSelectionSon();
        } else if (!nowSelect[0].equals("全部") && nowSelect[1].equals("全部") && nowSelect[2].equals("全部")) { // 2
            return this.selectionService.getCourseTwo(nowSelect[0]);
        } else if (!nowSelect[0].equals("全部") && !nowSelect[1].equals("全部") && nowSelect[2].equals("全部")) { // 3
            return this.selectionService.getDifficulty(nowSelect[0], nowSelect[1]);
        } else if (!nowSelect[0].equals("全部") && !nowSelect[1].equals("全部") && !nowSelect[2].equals("全部")) { // 4
            return this.selectionService.getNotall(nowSelect[0],nowSelect[1],nowSelect[2]);
        } else if (nowSelect[0].equals("全部") && nowSelect[1].equals("全部") && !nowSelect[2].equals("全部")) { // 5
            return this.selectionService.getCourseFive(nowSelect[2]);
        } else if (!nowSelect[0].equals("全部") && nowSelect[1].equals("全部") && !nowSelect[2].equals("全部")) { // 6
            return this.selectionService.getCourseSix(nowSelect[0], nowSelect[2]);
        } else {
            return null;
        }
    }
}
