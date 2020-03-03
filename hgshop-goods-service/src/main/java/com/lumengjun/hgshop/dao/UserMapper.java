package com.lumengjun.hgshop.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lumengjun.hgshop.pojo.User;

public interface UserMapper {

	
	@Select("SELECT * FROM hg_user WHERE username=#{userName}  AND password=#{passWord}  LIMIT 1")
	User login(@Param("userName")String userName,@Param("passWord") String passWord);

}
