package com.libraryms.controller;


import com.libraryms.pojo.User;
import com.libraryms.result.MailResponse;
import com.libraryms.result.Response;
import com.libraryms.service.MailService;
import com.libraryms.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class ForgetPasswordController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MailService mailService;

    @CrossOrigin
    @PostMapping("api/forgetPassword")
    @ResponseBody
    public Response forgetPassword(@RequestBody User requestUser) {
        User forgetPasswordUser = userService.getByUserName(requestUser);
        if(forgetPasswordUser == null) {
            return Response.no("用户名不存在");
        } else {
            try {
                userService.updatePassword(requestUser);
                //System.out.println(requestUser.getPassword());
                return Response.yes("修改成功");
            } catch (Exception e) {
                return Response.no("异常操作",e);
            }
        }
    }

    @CrossOrigin
    @RequestMapping("api/forgetPassword/code")
    @ResponseBody
    public MailResponse getForgetPasswordCode(@RequestBody User user) {
        User forgetUser = userService.getByUserNameAndEmail(user);
        MailResponse mailResponse = new MailResponse();
        if (forgetUser == null) {
            mailResponse.setCode(-1);
            mailResponse.setMsg("用户名与邮箱不匹配");
        } else {
            mailResponse.setCode(0);
        }
        return mailResponse;
    }

    @CrossOrigin
    @RequestMapping("api/forgetPassword/mail")
    @ResponseBody
    public MailResponse getForgetPasswordMail(@RequestBody User user) {
        User forgetUser = userService.getByUserNameAndEmail(user);
        MailResponse response = new MailResponse();
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您修改密码的验证码为: "+checkCode;
        if(forgetUser == null) {
            response.setCode(-1);
        } else {
            response.setCode(0);
            try {
                mailService.sendMail(user.getEmail(),"修改密码验证码",message);
            } catch (Exception e) {
                response.setData(e);
                return response;
            }
            response.setData(checkCode);
        }
        return response;
    }
}
