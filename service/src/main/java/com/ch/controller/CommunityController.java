package com.ch.controller;

import com.ch.models.Community;
import com.ch.models.User;
import com.ch.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ape")
public class CommunityController {

    @Autowired
    CommunityService communityService;

    // 猿问页面信息
    @PostMapping("/getApe")
    public Community[] getCommunity(){
        System.out.println("getCommunity");
        return this.communityService.getCommunity();
    }

    // 猿问登录用户头像，用户名
    @PostMapping("/getUserpic")
    public User getUserpic(@RequestBody int id){
        System.out.println(id);
        return this.communityService.getUserpic(id);
    }

    // 获取猿问问题详细页面提问者信息，回答内容
    @PostMapping("/getApeCommunity")
    public Community getApeCommunity(@RequestBody int id){
        System.out.println("你好:"+id);
        return this.communityService.getApeCommunity(id);
    }

    // ch-ape-quiz获取分类信息
    @GetMapping("/getClassify")
    public String[] getClassify() {
        return this.communityService.getClassify();
    }

    // ch-ape-quiz插入community信息
    @PostMapping("/setCommunity")
    public int setCommunity(@RequestBody Community quiz) {
        return this.communityService.setCommunity(quiz);
    }

}
