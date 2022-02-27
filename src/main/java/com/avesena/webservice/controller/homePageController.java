package com.avesena.webservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class homePageController {

    @Value("spring.application.name")
    String appName;

    @GetMapping("/")
    public String homePage(Model model){
        return "index";
    }

    @GetMapping("/logon")
    public String logonPage(Model model) {
        return "logon";
    }
}