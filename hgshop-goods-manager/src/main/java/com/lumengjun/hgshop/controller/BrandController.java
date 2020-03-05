package com.lumengjun.hgshop.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 规格的管理
 * @author ASUS
 *
 */
@Controller
@RequestMapping("brand") 
public class BrandController {

	@RequestMapping("list")
	public String list(@RequestParam(defaultValue="1")int page){
		return "brand/list";
		
	}
	
}
