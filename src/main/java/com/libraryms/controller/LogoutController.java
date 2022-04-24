package com.libraryms.controller;


import com.libraryms.pojo.User;
import com.libraryms.result.Response;
import com.libraryms.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LogoutController {
    @Autowired
    private UserServiceImpl service;

    @CrossOrigin
    @PostMapping(value = "api/userCenter/confirm")
    @ResponseBody
    public Response userConfirm(@RequestBody User requestUser,HttpSession session) {
        User updateUser = (User) session.getAttribute("session_user");
        if(Objects.equals(updateUser.getPassword(), requestUser.getPassword())) {
            return Response.yes("密码一致",updateUser.getUsername());
        } else {
            return Response.no("原密码不正确");
        }
    }
    @CrossOrigin
    @PostMapping(value = "api/userCenter/update")
    @ResponseBody
    public Response updatePassword(@RequestBody User requestUser) {
        User updateUser = service.getByUserName(requestUser);
        if(updateUser == null) {
            return Response.no("操作失败");
        } else {
            try {
                service.updatePassword(requestUser);
                return Response.yes("修改成功,请重新登录");
            } catch (Exception e) {
                return Response.no("异常操作",e);
            }

        }
    }

    @CrossOrigin
    @PostMapping(value = "api/logout")
    @ResponseBody
    public Response logout(HttpSession session) {
        session.removeAttribute("session_user");
        session.removeAttribute("session_userList");
        return Response.yes("成功安全退出");
    }
}
