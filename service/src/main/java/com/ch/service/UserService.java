package com.ch.service;

import com.ch.models.User;
import com.ch.models.Ape;
import com.ch.models.Notes;
import com.ch.models.Person;
import com.ch.models.PersonCourse;

public interface UserService {
    int add(User user);
    User[] judgeLogin(String name);
    Person getPerson(String name);
    PersonCourse[] getPersonCourse(int id);
    Ape[] getPersonApeQuiz(int id);
    Ape[] getPersonApeAnswer(int id);
    Ape[] getPersonApeAttention(int id);
    Notes[] getNotes(int id);
}
