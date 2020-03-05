package com.lumengjun.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.lumengjun.hgshop.pojo.CallBack;
import com.lumengjun.hgshop.pojo.Spec;

public interface SpecService {

	/**
	 * 进行规格查询   分页  名称模糊查询
	 * @param name
	 * @param page
	 * @return
	 */
	PageInfo<Spec> list(String name,int page);
	/**
	 * 添加规格
	 * @param spec
	 * @return
	 */
	int addSpec(Spec spec);
	
	int update(Spec spec);
	/**
	 * 规格id进行删除
	 * @param id
	 * @return
	 */
	CallBack delete(int id);
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
	CallBack deleteBatch(int[] ids);
}
