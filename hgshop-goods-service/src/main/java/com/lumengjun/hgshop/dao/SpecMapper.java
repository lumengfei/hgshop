package com.lumengjun.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lumengjun.hgshop.pojo.Spec;
import com.lumengjun.hgshop.pojo.SpecOption;

public interface SpecMapper {

	List<Spec> list(@Param("name")String name);

	
	
	void addSpec(Spec spec);

	void addOption(SpecOption specOption);

	int updateSpec(Spec spec);

	int updateSpecOution(int id);

	void updateSpec(int id);

	Spec findById(int id);

	void updateSpecOutionBatch(int[] ids);

	void updateSpecBatch(int[] ids);

}
