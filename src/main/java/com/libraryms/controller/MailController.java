package com.libraryms.controller;

import com.libraryms.pojo.User;
import com.libraryms.result.MailResponse;
import com.libraryms.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Random;


@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @CrossOrigin
    @RequestMapping("api/sign/mail")
    @ResponseBody
    public MailResponse<String> getCheckCode(@RequestBody User user) {
        MailResponse mailResponse = new MailResponse();
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为: "+checkCode;
        try {
            mailService.sendMail(user.getEmail(),"注册验证码",message);
        } catch (Exception e) {
            mailResponse.setData(e);
            return mailResponse;
        }
        mailResponse.setData(checkCode);
        return mailResponse;
    }

}
