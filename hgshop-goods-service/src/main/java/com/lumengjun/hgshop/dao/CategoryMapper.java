package com.lumengjun.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.lumengjun.hgshop.pojo.Category;

public interface CategoryMapper {

	List<Category> tree();

	
	@Insert("INSERT INTO hg_category(parent_id,name) VALUES(#{parentId},#{name})")
	void addCategory(Category category);


	@Update("UPDATE hg_category SET name=#{name} WHERE id =#{id}")
	void updateCategory(Category category);


	@Delete("DELETE FROM hg_category WHERE id =#{value}")
	void deleteCategory(Integer id);
	Category findById(Integer id);
}
