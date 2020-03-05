package com.lumengjun.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.lumengjun.hgshop.pojo.Spec;
import com.lumengjun.hgshop.pojo.SpecOption;

public interface SpecMapper {

	List<Spec> list(@Param("name")String name);

	
	
	void addSpec(Spec spec);

	void addOption(SpecOption specOption);

	@Update("UPDATE hg_spec SET spec_name =#{specName} WHERE id=#{id}")
	void updateSpec(Spec spec);

	@Delete("DELETE FROM hg_spec_option WHERE spec_id =#{value}")
	int deleteSpecOution(int id);

	@Delete("DELETE FROM hg_spec WHERE id=#{value}")
	void deleteSpec(int id);

	Spec findById(int id);

	void deleteSpecOutionBatch(int[] ids);

	void deleteSpecBatch(int[] ids);

}
