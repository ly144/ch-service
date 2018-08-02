package com.ch.controller;

import com.aliyuncs.exceptions.ClientException;
import com.ch.models.User;
import com.ch.models.UserLogin;
import com.ch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin
@RestController
@RequestMapping(value = "/userjwt", produces = "text/html;charset=UTF-8")
public class UserjwtController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户登录
     *
     * @param userLogin
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping("/login")
    public String getToken(@RequestBody UserLogin userLogin) throws AuthenticationException {
        System.out.println(userLogin.getUsername()+"-"+userLogin.getPassword());
        return iUserService.login(userLogin.getUsername(), userLogin.getPassword());
    }

    /**
     * 用户注册
     *
     * @param userLogin 用户信息
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping("/register")
    public String register(@RequestBody UserLogin userLogin) throws AuthenticationException {
        String code = (String) redisTemplate.boundHashOps("smscode").get(userLogin.getPhone());
        System.out.println(code);
        if (userLogin.getCode().equals(code)) {
            return iUserService.register(userLogin);
        } else {
            return "false";
        }
    }

    /**
     * 发送短信
     * @param phone
     */
    @PostMapping("/sendCode")
    public String sendCode(@RequestBody String phone) {
        String regExp = "^((13[0-9])|(15[0-9])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        if (m.matches()) {
            String smscode = (long) (Math.random() * 1000000) + ""; // 随机生成6位验证码
            System.out.println(phone+","+smscode);
            this.redisTemplate.boundHashOps("smscode").put(phone, smscode);
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone); // 手机号为key，验证码为值
            map.put("code", smscode);
            jmsMessagingTemplate.convertAndSend("sms", map);
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 刷新密钥
     *
     * @param authorization 原密钥
     * @return 新密钥
     * @throws AuthenticationException 错误信息
     */
    @GetMapping(value = "/refreshToken")
    public String refreshToken(@RequestHeader String authorization) throws AuthenticationException {
        return iUserService.refreshToken(authorization);
    }

}
