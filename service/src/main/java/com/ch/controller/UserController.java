package com.ch.controller;

import com.ch.dao.User;
import com.ch.models.UserLogin;
import com.ch.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String Learn() {
        return "learn-res";
    }

    @PostMapping("/login")
    public boolean judgeLogin(@RequestBody UserLogin userLogin) {
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
        System.out.println(userLogin);
        User[] users = this.userService.judgeLogin(username);
        for (User user : users) {
            System.out.println(user);
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    /**
     * 注册
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addLearn(HttpServletRequest request , HttpServletResponse response){
        int id = request.getIntHeader("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if(name == null){
            System.out.println("name is null");
            return;
        }
        if(password == null){
            System.out.println("password is null");
            return;
        }
        if(id == 0){
            System.out.println("id is null");
            return;
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        int index=userService.add(user);
        if(index>0){
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
    }

}
