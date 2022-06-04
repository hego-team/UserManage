package com.bytedance.hego.controller;

import com.bytedance.hego.bean.User;
import com.bytedance.hego.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.login(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //登录成功
                session.setAttribute("currentUser", user);
                return "index";
            } else {
                model.addAttribute("message", "login failed");
                return "login";
            }
        } else {
            model.addAttribute("message", "username or password error");
            return "login";
        }
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            session.removeAttribute("currentUser");
        }
        return "login";
    }
}
