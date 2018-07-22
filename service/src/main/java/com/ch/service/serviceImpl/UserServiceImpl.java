package com.ch.service.serviceImpl;

import com.ch.dao.User;
import com.ch.dao.UserMapper;
import com.ch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public int add(User user) {
        return this.userMapper.add(user);
    }

    @Override
    public User[] judgeLogin(String name) {
        return this.userMapper.getUserByName(name);
    }
}
