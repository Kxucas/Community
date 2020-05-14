package com.community.community.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name,Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
