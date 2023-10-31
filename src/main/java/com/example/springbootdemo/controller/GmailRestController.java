package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.GmailSeenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/mails")
public class GmailRestController {

    @Autowired
    private GmailSeenderService gmailSeenderService;
    @GetMapping("//send/{to}/{subject}/{msg}\"")
    public ResponseEntity<String> sendMessage(@PathVariable(name="to")String to,
                                              @PathVariable(name="subject")String subject,
                                              @PathVariable(name="msg")String msg){
        gmailSeenderService.sendMsg(to, subject, msg + ". Server time : " + new Date());

        return ResponseEntity.ok().body("Message has been send successfully");

    }



}
