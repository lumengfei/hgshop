package com.lumengjun.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.pojo.Spec;

public interface SpecService {

	PageInfo<Spec> list(String name,int page);
	
	int addSpec(Spec spec);
	
	int update(Spec spec);
	
	int delete(int id);
	/**
	 * 规格id查询一个规格    用于修改回显
	 * @param id
	 * @return
	 */
	Spec findById(int id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int deleteBatch(int[] ids);
}
