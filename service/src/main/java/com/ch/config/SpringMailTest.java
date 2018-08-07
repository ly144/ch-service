package com.ch.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SpringMailTest {

    @Autowired
    private JavaMailSender mailSender;

    public void sendTxtMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("1530314122@qq.com");
        simpleMailMessage.setFrom("1192830448@qq.com");
        simpleMailMessage.setSubject("一封情书");
        simpleMailMessage.setText("爱你哟");
        mailSender.send(simpleMailMessage);
        System.out.println("邮件已发送");
    }
}
