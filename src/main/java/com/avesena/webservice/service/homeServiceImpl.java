package com.avesena.webservice.service;

import org.springframework.stereotype.Service;

@Service
public class homeServiceImpl implements homeService{

    public String gethomePage(){
        return "index";
    }
}
