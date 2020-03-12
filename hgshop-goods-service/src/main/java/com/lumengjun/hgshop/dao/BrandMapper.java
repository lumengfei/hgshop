package com.lumengjun.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lumengjun.hgshop.pojo.Brand;

public interface BrandMapper {

	/*@Select("SELECT id,name,first_char as firstChar,deleted_flag as deletedFlag FROM hg_brand WHERE deleted_flag=0")*/
	List<Brand> listBrand(@Param("first")String first);

	@Insert("INSERT INTO hg_brand(name,first_char,deleted_flag) VALUES(#{name},#{firstChar},0)")
	void addBrand(Brand brand);

	@Select("SELECT id,name,first_char as firstChar,deleted_flag as deletedFlag FROM hg_brand WHERE id=#{value}")
	Brand findById(Integer id);

	@Update("UPDATE hg_brand SET name=#{name},first_char=#{firstChar} WHERE id=#{id}")
	void updateBrand(Brand brand);
	@Update("UPDATE hg_brand SET deleted_flag=1 WHERE id=#{value}")
	void updateBrandById(Integer id);

	List<Brand> listAll();

	
}
