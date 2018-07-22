package com.ch.service;

import com.ch.dao.User;

public interface UserService {
    int add(User user);
    User[] judgeLogin(String name);
}
