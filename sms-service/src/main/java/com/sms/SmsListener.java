package com.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @JmsListener(destination = "sms")
    public void sendSms(Map<String, String> map) {
        try {
            System.out.println(map.get("phone"));
            System.out.println(map.get("code"));
            SendSmsResponse response = smsUtil.sendSms(map.get("phone"), map.get("code"));
            System.out.println("code:" + response.getCode());
            System.out.println("message:" + response.getMessage());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
