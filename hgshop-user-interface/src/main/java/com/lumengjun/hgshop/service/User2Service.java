package com.lumengjun.hgshop.service;

import com.lumengjun.hgshop.pojo.User;

public interface User2Service {

	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	User login(String username, String password);

	/**
	 * 用户注册
	 * @param user 注册信息
	 * @return
	 */
	User register(User user);

}
