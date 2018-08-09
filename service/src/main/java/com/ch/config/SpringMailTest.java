package com.ch.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SpringMailTest {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public int sendTxtMail(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("1192830448@qq.com");
        simpleMailMessage.setSubject("邮箱验证码");
        String emailCode = (long) (Math.random() * 1000000) + ""; // 随机生成6位验证码
        stringRedisTemplate.opsForValue().set(email, emailCode);
        simpleMailMessage.setText(emailCode);
        mailSender.send(simpleMailMessage);
        return 1;
    }
}
