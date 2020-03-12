package com.lumengjun.hgshop.controller;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.pojo.Brand;
import com.lumengjun.hgshop.pojo.CallBack;
import com.lumengjun.hgshop.service.GoodsService;

/**
 * 规格的管理
 * @author ASUS
 *
 */
@Controller
@RequestMapping("brand") 
public class BrandController {

	@Reference
	GoodsService goodsService;
	
	@RequestMapping("list")
	public String list(Model model,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="")String first){
		System.err.println(first);
		PageInfo<Brand> info =goodsService.listBrand(first, page);
		model.addAttribute("info", info);
		model.addAttribute("first", first);
		return "brand/list";
		
	}
	
	@RequestMapping("add")
	@ResponseBody
	public CallBack addBrand(Brand brand){
		return goodsService.addBrand(brand);
	}
	
	
	
	@RequestMapping("getBrand")
	@ResponseBody
	public Brand getBrand(Integer id){
		return goodsService.findById(id);
	}
	
	
	@RequestMapping("update")
	@ResponseBody
	public CallBack updateBrand(Brand brand){
		return goodsService.updateBrand(brand);
	}
	
	
	@RequestMapping("delBrand")
	@ResponseBody
	public CallBack delBrand(Integer id){
		return goodsService.deleteBrand(id);
	}
}
