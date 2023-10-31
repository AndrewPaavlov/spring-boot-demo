package com.example.springbootdemo.service;

import com.example.springbootdemo.config.GmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GmailSeenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMsg(String to,String subject,String msg){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(msg);

        javaMailSender.send(simpleMailMessage);
        System.out.println("done");
    }
}
