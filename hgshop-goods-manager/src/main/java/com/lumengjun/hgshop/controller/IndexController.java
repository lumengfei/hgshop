package com.lumengjun.hgshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author ASUS
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping({"/","index"})
	public String index(){
		return "index";
	}

}
