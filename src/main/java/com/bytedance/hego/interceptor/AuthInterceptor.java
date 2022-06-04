package com.bytedance.hego.interceptor;

import com.bytedance.hego.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        //如果未登录
        if (currentUser == null) {
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        return true;
    }
}
