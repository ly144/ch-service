package com.ch.service.serviceImpl;

import com.ch.dao.CommunityMapper;
import com.ch.models.Answer;
import com.ch.models.Community;
import com.ch.models.User;
import com.ch.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    CommunityMapper communityMapper;

    // 猿问页面信息
    @Override
    public  Community[] getCommunity(){
        Community[] qs = this.communityMapper.getCommunity();
        for (Community q : qs) {
            Answer[] a = this.communityMapper.getAnswer(q.getId());
            q.setAnswer(a);
        }
        return qs;
    }

    //猿问页面登陆者信息
    @Override
    public User getUserpic(int id) {
        return this.communityMapper.getUserpic(id);
    }

    // 获取猿问问题详细页面提问者信息，回答内容
    @Override
    public Community getApeCommunity(int id) {
        Community us = this.communityMapper.getApeCommunity(id);
        Answer[] a = this.communityMapper.getApeAnswer(us.getId());
        us.setAnswer(a);
        return us;
    }

    // ch-ape-quiz获取分类信息
    @Override
    public String[] getClassify(){
        return this.communityMapper.getClassify();
    }

    // ch-ape-quiz插入提问信息
    @Override
    public int setCommunity(Community quiz){
        return this.communityMapper.setCommunity(quiz);
    }
}
