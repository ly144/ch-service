package com.ch.service;

import com.ch.models.Answer;
import com.ch.models.Community;
import com.ch.models.User;

public interface CommunityService {

    // ch-ape 猿问页面信息
    Community[] getCommunity();

    // ch-ape 猿问页面登录者信息
    User getUserpic(int id);

    // ch-community 获取猿问问题详细页面提问者信息，回答内容
    Community getApeCommunity(int id);

    // ch-ape-quiz 获取分类信息
    String[] getClassify();

    // ch-ape-quiz 插入提问信息
    int setCommunity(Community quiz);

    // 插入猿问问题详细页面回答者内容,ch-community
    int setApeAnswer(Answer answer);
}
