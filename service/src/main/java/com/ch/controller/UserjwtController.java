package com.ch.controller;

import com.aliyuncs.exceptions.ClientException;
import com.ch.config.SpringMailTest;
import com.ch.models.User;
import com.ch.models.UserBind;
import com.ch.models.UserLogin;
import com.ch.models.UserResponse;
import com.ch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin
@RestController
@RequestMapping("/userjwt")
public class UserjwtController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SpringMailTest springMailTest;

    /**
     * 用户登录
     *
     * @param userLogin
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping("/login")
    public UserResponse getToken(@RequestBody UserLogin userLogin) throws AuthenticationException {
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
        String phoneCode = this.stringRedisTemplate.opsForValue().get(userLogin.getPhone()); // 获取验证码
//        String code = (String) redisTemplate.boundHashOps("smscode").get(userLogin.getPhone());
        if (phoneCode.equals(userLogin.getCode())) {
            this.stringRedisTemplate.delete(userLogin.getPhone());
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
            this.stringRedisTemplate.opsForValue().set(phone, smscode); // redis记录，手机号为key，验证码为值
//            this.redisTemplate.boundHashOps("smscode").put(phone, smscode);
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            map.put("code", smscode);
            jmsMessagingTemplate.convertAndSend("sms", map); // 消息中间件的发送
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 发送邮件
     * @param email
     * @return
     */
    @PostMapping("/sendEmail")
    public int sendEmail(@RequestBody String email) {
        return springMailTest.sendTxtMail(email);
    }

    /**
     * 判断验证码
     * @return
     */
    @PostMapping("/judgeCode")
    public int judgeCode(@RequestBody UserBind userBind) {
        String key = userBind.getKey();
        String code = userBind.getCode();
        int id = userBind.getId();
        System.out.println(key + "," + code + "," + id);
        String emailCode = this.stringRedisTemplate.opsForValue().get(key);
        if (emailCode.equals(code)) {
            this.stringRedisTemplate.delete(key);
            if ( ( key.substring(key.length()-7 ,key.length()) ).equals("@qq.com") )
                return this.iUserService.changeEmail(key, id);
            else
                return this.iUserService.changePhone(key, id);
        } else {
            return 0;
        }
    }

    @PostMapping("/changePass")
    public int changePass(@RequestBody String[] pass) {
        System.out.println(pass[0] + "," + pass[1] + "," + pass[2] + "," + pass[3]);
        if (iUserService.login(pass[3], pass[0]) != null) {
            return this.iUserService.changePass(pass[1], Integer.parseInt(pass[4]));
        } else {
            return 0;
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
