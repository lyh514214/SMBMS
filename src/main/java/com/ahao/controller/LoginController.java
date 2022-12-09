package com.ahao.controller;

import com.ahao.pojo.User;
import com.ahao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 登录控制器
 * @Author: ahao
 * @Date: 2022/12/6 15:42
 **/
@Controller
@RequestMapping("user")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * @Description: 登录页面
    **/
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * @Description:   登录校验
     * @param userCode  账号
     * @param userPassword  密码
     * @param request  请求信息
     * @param session  session信息
    **/
    @RequestMapping("doLogin")
    public String doLogin(String userCode, String userPassword, HttpServletRequest request,HttpSession session){
        User user = userService.login(userCode,userPassword);
        if (user != null){
            session.setAttribute("userSession",user);
            return "redirect:/user/main";
        }
        request.setAttribute("error","账号或者密码错误，请重新输入");
        return "login";
    }

    /**
     * @Description: 登录拦截器
     * @param session session用户数据
    **/
    @RequestMapping("main")
    public String main(HttpSession session){
        User user = (User) session.getAttribute("userSession");
        if (user == null){
            return "redirect:/syserror";
        }
        return "frame";
    }

    /**
     * @Description: 注销
    **/
    @RequestMapping("logout")
    public String logout(){
        return "login";
    }


}
