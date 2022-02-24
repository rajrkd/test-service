package com.avesena.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.avesena.webservice.service.homeService;

@RestController
public class homePageController {

    @Value("spring.application.name")
    String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @GetMapping("/")
    public String homePage(Model model){
        return "index";
    }

}
