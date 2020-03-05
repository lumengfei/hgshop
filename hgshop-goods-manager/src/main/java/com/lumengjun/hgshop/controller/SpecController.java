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
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="")String name,
			Model model){
		PageInfo<Spec> info = specService.list(name, page);
		request.setAttribute("queryName", name);
		request.setAttribute("info", info);
		
		return "spec/list";
		
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
		List<SpecOption> options = spec.getOptions();
		for (SpecOption specOption : options) {
			if(specOption.getOptionName()==null){
				options.remove(specOption);
			}
		}
		spec.setOptions(options);
		//System.err.println("spec 处理后：" + spec);
		//调用服务
		int add =specService.addSpec(spec);
		return new CallBack(1, "", "添加成功");
	}
	
}
