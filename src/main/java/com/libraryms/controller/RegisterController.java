package com.libraryms.controller;


import com.libraryms.pojo.User;
import com.libraryms.result.Response;
import com.libraryms.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;

    @CrossOrigin
    @PostMapping(value = "api/sign")
    @ResponseBody
    public Response register(@RequestBody User requestUser, HttpSession session) {

        User registerUser = userService.getByUserName(requestUser);
        if(registerUser == null) {
            try {
                userService.insertUser(requestUser);
                session.setAttribute("session_user", requestUser);
                return Response.yes("注册成功");//0
            } catch (Exception e) {
                return Response.no("异常操作",e);
            }

        } else {
            return Response.no("用户名已存在");//-1
        }
    }
}
