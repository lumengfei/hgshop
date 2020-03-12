package com.lumengjun.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lumengjun.hgshop.pojo.CallBack;
import com.lumengjun.hgshop.pojo.Category;
import com.lumengjun.hgshop.service.GoodsService;
/**
 * 类别的管理
 * @author ASUS
 *
 */

@RequestMapping("cat")
@Controller
public class CategoryController {

	@Reference
	GoodsService goodsService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request){
		return "cat/list";
		
	}
	
	
	/**
	 * 用于树状查询类别
	 * @param request
	 * @return
	 */
	@RequestMapping("treeData")
	@ResponseBody
	public List<Category>  treeData(HttpServletRequest request){
	
		return goodsService.treeCategory();
	}
	
	
	/**
	 * 添加类别
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public CallBack add(Integer parentId,String name){
		Category category = new Category();
		category.setParentId(parentId);
		category.setName(name);
		
		CallBack callBack=goodsService.addCategory(category);
		return callBack;
	}
	/**
	 * 修改分类
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public CallBack update(Integer id,String name){
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		CallBack callBack=goodsService.updateCategory(category);
		return callBack;
	}
	
	/**
	 * 删除分类
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public CallBack delete(int id){
		CallBack callBack=goodsService.deleteCategory(id);
		return callBack;
		
	}
	
	
	
}
