package com.community.community.controller;

import com.community.community.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class UserLogin {

    @Autowired
    Service service;
    @RequestMapping("/user/login")
    public String loginpage(){
        return "sign";
    }
    @RequestMapping("/user/sign")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, Model model){
        service.sign(username,password);
        return "redirect:/index";
    }
}
