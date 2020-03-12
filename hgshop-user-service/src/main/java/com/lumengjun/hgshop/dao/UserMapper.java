package com.lumengjun.hgshop.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lumengjun.hgshop.pojo.User;

public interface UserMapper {
	
	@Select("SELECT * FROM hg_user WHERE username=#{username} AND password=#{password}")
	User login(@Param("username")String username,@Param("password") String password);

	int addUser(User user);

	@Select("SELECT * FROM hg_user WHERE uid=#{value}")
	User findUserByUid(Integer uid);

}
