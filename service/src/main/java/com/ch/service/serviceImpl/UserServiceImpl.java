package com.ch.service.serviceImpl;

import com.ch.models.*;
import com.ch.dao.UserMapper;
import com.ch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User judgeLogin(String name) {
        return this.userMapper.getUserByName(name);
    }

    @Override
    public Result getPicture(int id) {
        return this.userMapper.getPicture(id);
    }

    @Override
    public Person getPerson(int id) {
        return this.userMapper.getPerson(id);
    }

    @Override
    public PersonCourse[] getPersonCourse(int id) {
        return this.userMapper.getPersonCourse(id);
    }

    @Override
    public Ape[] getPersonApeQuiz(int id) {
        return this.userMapper.getPersonApeQuiz(id);
    }

    @Override
    public Ape[] getPersonApeAnswer(int id) {
        return this.userMapper.getPersonApeAnswer(id);
    }

    @Override
    public Ape[] getPersonApeAttention(int id) {
        return this.userMapper.getPersonApeAttention(id);
    }

    @Override
    public Notes[] getNotes(int id) {
        return this.userMapper.getNotes(id);
    }

    @Override
    public int changePerson(Person person) {
        return this.userMapper.changePerson(person);
    }
}
