package com.libraryms.interceptor;


import com.libraryms.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("session_user");
        if(loginUser == null&&!request.getMethod().equals("OPTIONS")) {
            request.setAttribute("msg","没有权限，请先登录");
            //System.out.println("拦截");
            return false;
        }
        return true;
    }
}
