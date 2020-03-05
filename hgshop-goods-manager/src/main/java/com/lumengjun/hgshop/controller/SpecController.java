package com.lumengjun.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;



import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.pojo.CallBack;
import com.lumengjun.hgshop.pojo.Spec;
import com.lumengjun.hgshop.pojo.SpecOption;
import com.lumengjun.hgshop.service.SpecService;

/**
 * 规格的管理
 * @author ASUS
 *
 */
@Controller
@RequestMapping("spec") 
public class SpecController {

	@Reference
	SpecService specService;
	
	/**
	 * 进行规格列表查询
	 * @param request
	 * @param page  当前页
	 * @param name  规格名称
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="")String name){
		PageInfo<Spec> info = specService.list(name, page);
		request.setAttribute("queryName", name);
		request.setAttribute("info", info);
		
		return "spec/list";
		
	}
	
	/**
	 * 根据id查询一条数据用于回显
	 * @param id
	 * @return
	 */
	@RequestMapping("getSpec")
	@ResponseBody
	public Spec getSpec(int id){
		System.err.println("======================");
		Spec findById = specService.findById(id);
		System.err.println(findById);
		return findById;
	}
	
	/**
	 * 修改
	 * @param spec
	 * @return
	 */
	@RequestMapping("updateSpec")
	@ResponseBody
	public CallBack updateSpec(Spec spec){
		//进行数据处理
		List<SpecOption> options = spec.getOptions();
		for (SpecOption specOption : options) {
			if(specOption.getOptionName()==null){
				options.remove(specOption);
			}
		}
		spec.setOptions(options);
		
		//进行修改
		CallBack callBack= specService.update(spec);
		
		return callBack;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public CallBack add(HttpServletRequest request,
			Spec spec){ 
		//System.err.println(spec);
		//System.out.println();
		//spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		//处理数据
		
		//System.err.println("spec 处理后：" + spec);
		//调用服务
		int add =specService.addSpec(spec);
		return new CallBack(1, "", "添加成功");
	}
	
	/**
	 * 根据id进行删除
	 * @param id
	 * @return
	 */
	@RequestMapping("delSpec")
	@ResponseBody
	public CallBack delSpec(int id){
		
		CallBack callBack= specService.delete(id);
		
		return callBack;
	}
	
	
	/**
	 * 根据id进行删除
	 * @param id
	 * @return
	 */
	@RequestMapping("delSpecBatch")
	@ResponseBody
	public CallBack delSpecBatch(@RequestParam(name="ids[]")int[] ids){
		
		CallBack callBack= specService.deleteBatch(ids);
		
		return callBack;
	}
	
}
