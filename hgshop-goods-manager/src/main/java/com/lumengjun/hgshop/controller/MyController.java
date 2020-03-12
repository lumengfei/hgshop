package com.lumengjun.hgshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("my")
public class MyController {

	@RequestMapping("ssss")
	@ResponseBody
	public String sss(String msg){
		
		
	return	msg;
	}
	
	@RequestMapping("my")
	public String my(){
		return "my";
		
	}
	
}
