package com.ch.service;

import com.ch.models.Community;
import com.ch.models.User;

public interface CommunityService {

    // 猿问页面信息
    Community[] getCommunity();

    // 猿问页面登录者信息
    User getUserpic(int id);

    // 获取猿问问题详细页面提问者信息，回答内容
    Community getApeCommunity(int id);

    // ch-ape-quiz获取分类信息
    String[] getClassify();

    // ch-ape-quiz插入提问信息
    int setCommunity(Community quiz);
}
