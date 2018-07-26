package com.ch.service.serviceImpl;

import com.ch.models.User;
import com.ch.dao.UserMapper;
import com.ch.models.Ape;
import com.ch.models.Notes;
import com.ch.models.Person;
import com.ch.models.PersonCourse;
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

    @Override
    public Person getPerson(String name) {
        return this.userMapper.getPerson(name);
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
}
