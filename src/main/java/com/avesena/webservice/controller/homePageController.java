package com.avesena.webservice.controller;

//import com.avesena.webservice.service.WebUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class homePageController {

    @GetMapping(value = {"/","/index"})
    public String homepage(){
        return "index";
    }


    @RequestMapping(value = "/login", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    
    @GetMapping("/error")
    public String errorpage(){
    	//System.out.println("reached here");
        return "error";
    }
    
    @RequestMapping(value = "/userInfo", method= RequestMethod.GET)
    public String employeeInfo(Model model, Principal principal){
    	System.out.println("Principal user "+principal.getName());
    	String userName = principal.getName();
    	User loggedInUser = (User)((Authentication) principal).getPrincipal(); 
    	//String userInfo = WebUtils.toString(loggedInUser);
    	model.addAttribute("username", userName);
    	model.addAttribute("User",userName);
        return "employeePage";
    }
    
    @RequestMapping(value = "/admin", method= RequestMethod.GET)
    public String adminPage(Model model, Principal principal){
    	
    	String userName = principal.getName();
    	User loggedInUser = (User)((Authentication) principal).getPrincipal(); 
    //	String userInfo = WebUtils.toString(loggedInUser);
    	model.addAttribute("username", userName);
    	model.addAttribute("User",userName);
        return "adminPage";
    }
    
    @RequestMapping(value = "/accessdenied", method= RequestMethod.GET)
    public String accessDenied(Model model, Principal principal){
    	System.out.println("principal "+ principal.getName());
    	if (principal != null) {
    		User loggedInUser = (User)((Authentication) principal).getPrincipal(); 
    		System.out.println("Logged in "+loggedInUser.toString());
 //   		String userInfo = WebUtils.toString(loggedInUser);
    		model.addAttribute("User",loggedInUser.getUsername());
 //   		System.out.println("user info " +userInfo);
    		String message ="Hi "+principal.getName() + "  You do not have permission to access this page.";
    		model.addAttribute("message", message);
    	}
        return "accessdenied";
    }
    
    
    

}
