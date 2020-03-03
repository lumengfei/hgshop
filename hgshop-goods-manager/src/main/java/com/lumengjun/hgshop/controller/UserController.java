package com.lumengjun.hgshop.controller;

import org.apache.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumengjun.hgshop.service.UserService;



/**
 * 
 * @author ASUS
 *
 */

@Controller
public class UserController {
	
	
	@Reference(timeout=2000,version="1.0.0")
	UserService userService;
	
	
	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String name,String password ) {
		
		System.out.println("name " + name + " password " + password);
		
		if(userService.login(name, password))
			return "redirect:/";
		else {
			return "login";
		}
	}

}
