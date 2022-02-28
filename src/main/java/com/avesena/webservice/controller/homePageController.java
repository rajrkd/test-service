package com.avesena.webservice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class homePageController {

    @GetMapping("/index")
    public String homePage(Model model){
        return "index";
    }

    @GetMapping("/logon")
    public String logonPage(Model model) {
        return "logon";
    }
}