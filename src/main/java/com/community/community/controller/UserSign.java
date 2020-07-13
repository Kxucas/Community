package com.community.community.controller;

import com.community.community.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class UserSign {
    @Autowired
    Service service;
    @RequestMapping("/user/userlogin")
    public String userloginpage(){
        return "sign";
    }

    @RequestMapping("/user/usersign")
    public String userlogin(@RequestParam("username")String username, @RequestParam("password")String password){
        if(service.querybyUsername(username)==null){

            return "error";
        }
        else if( (username!=null)&&service.querybyUsername(username).getPassword().equals(password) ){
            //login登陆界面
            return "profile";
        }
        else{
            return "index";
        }

    }
}
