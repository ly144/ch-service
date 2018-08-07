package com.ch.controller;

import com.ch.config.SpringMailTest;
import com.ch.models.*;
import com.ch.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SpringMailTest springMailTest;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String Learn() {
        springMailTest.sendTxtMail();
        return "learn-res";
    }

    /**
     * 登录
     * @param userLogin
     * @return boolean
     */
    @PostMapping("/login")
    public boolean judgeLogin(@RequestBody UserLogin userLogin) {
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
        System.out.println(userLogin);
        User user = this.userService.judgeLogin(username);
        System.out.println(user);
        if (user.getName().equals(username) && user.getPassword().equals(password)) {
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    }

    /**
     * 个人信息
     * @param id
     * @return Person
     */
    @PostMapping("/getPerson")
    public Person getPerson(@RequestBody int id) {
        System.out.println(id);
        return this.userService.getPerson(id);
    }

    /**
     * 个人信息课程
     * @param id
     * @return PersonCourse[]
     */
    @PostMapping("/getPersonCourse")
    public PersonCourse[] getPersonCourse(@RequestBody int id) {
        System.out.println(id);
        return this.userService.getPersonCourse(id);
    }

    /**
     * 个人信息之猿问之提问
     * @param id
     * @return Ape[]
     */
    @PostMapping("/getPersonApeQuiz")
    public Ape[] getPersonApeQuiz(@RequestBody int id) {
        System.out.println(id);
        return this.userService.getPersonApeQuiz(id);
    }

    /**
     *  个人信息之猿问之回答
     * @param id
     * @return Ape[]
     */
    @PostMapping("/getPersonApeAnswer")
    public Ape[] getPersonApeAnswer(@RequestBody int id) {
        System.out.println(id);
        return this.userService.getPersonApeAnswer(id);
    }

    /**
     * 个人信息之猿问之关注
     * @param id
     * @return Ape[]
     */
    @PostMapping("/getPersonApeAttention")
    public Ape[] getPersonApeAttention(@RequestBody int id) {
        System.out.println(id);
        return this.userService.getPersonApeAttention(id);
    }

    /**
     * 个人信息之猿问之笔记
     * @param id
     * @return
     */
    @PostMapping("/getNotes")
    public Notes[] getNotes(@RequestBody int id) {
        System.out.println(id);
        return this.userService.getNotes(id);
    }

    @PostMapping("setPerson")
    public int setPerson(@RequestBody Person person) {
        System.out.println(person);
        return this.userService.setPerson(person);
    }

}
