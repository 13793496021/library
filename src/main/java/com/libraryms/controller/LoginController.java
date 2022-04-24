package com.libraryms.controller;

import com.libraryms.pojo.User;
import com.libraryms.result.Response;
import com.libraryms.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;


@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;
    //登录
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Response login(@RequestBody User requestUser, HttpSession session) {
        User loginUser = userService.getByUserNameAndPassword(requestUser);
        List<User> users = userService.getByUserList(requestUser);
        if(loginUser == null){
            return Response.no("账号或密码错误");
        } else {
            session.setAttribute("session_user",loginUser);
            session.setAttribute("session_userList",users);
            return Response.yes("登录成功",loginUser.getUsername());
        }
    }
    //获取权限
    @CrossOrigin
    @PostMapping(value = "api/router")
    @ResponseBody
    public Response getRouter(HttpSession session) {
        User routerUser = (User) session.getAttribute("session_user");
        if(routerUser.getFlag() == 1) {
            return Response.yes("有权限");
        } else {
            return Response.no("没有权限");
        }
    }
    //获取侧边栏
    @CrossOrigin
    @PostMapping(value = "api/sideMenu")
    @ResponseBody
    public Response getMenu(HttpSession session) {
        User menuUser = (User) session.getAttribute("session_user");
        if(menuUser.getFlag() == 1) {
            return Response.yes("管理员");
        } else {
            return Response.no("用户");
        }
    }
    //获取Info
    @CrossOrigin
    @PostMapping(value = "api/userInfo")
    @ResponseBody
    public Response getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        //System.out.println(user);
        /*if(user == null) {
            return Response.no("登录超时,请先登录");
        } else {
            return Response.yes("操作成功",user.getUsername());
        }*/
        return Response.yes("操作成功",user.getUsername());
    }
    //个人中心获取信息
    @CrossOrigin
    @PostMapping(value = "api/userCenter")
    @ResponseBody
    public Response getInformation(HttpSession session) {
        List<User>  infoUser = (List<User>) session.getAttribute("session_userList");
        if(infoUser == null) {
            return Response.no("获取失败");
        } else {
            return Response.yes("获取成功",infoUser);
        }
    }
    //验证码
    @CrossOrigin
    @PostMapping(value = "api/login/code")
    @ResponseBody
    public Response getCode() {
        String [] Codes = new String[4];
        String Code = "";
        for(int i=0; i<4; i++) {
            Codes[i] = String.valueOf(new Random().nextInt(9) + 1);
            Code += Codes[i];
        }
        //System.out.println(Code);
        return Response.yes("成功生成验证码",Code);
    }
}













