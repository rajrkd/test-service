package com.avesena.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class homePageController {

    @GetMapping("/index")
    public String homepage(){
        return "index";
    }

    @GetMapping("/")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
