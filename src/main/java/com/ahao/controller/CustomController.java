package com.ahao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 自定义控制器
 * @Author: ahao
 * @Date: 2022/12/8 18:13
 **/
@Controller
public class CustomController {

    @RequestMapping("/")
    public String main(){
        return "login";
    }

    @RequestMapping("syserror")
    public String error(){
        return "syserror";
    }
}
