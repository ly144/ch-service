package com.ch.service;

import com.ch.models.*;

public interface UserService {
    User judgeLogin(String name);
    Result getPicture(int id);
    Person getPerson(int id);
    PersonCourse[] getPersonCourse(int id);
    Ape[] getPersonApeQuiz(int id);
    Ape[] getPersonApeAnswer(int id);
    Ape[] getPersonApeAttention(int id);
    Notes[] getNotes(int id);
    int changePerson(Person person);
}
