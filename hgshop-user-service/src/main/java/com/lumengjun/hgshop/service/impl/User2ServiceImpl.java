package com.lumengjun.hgshop.service.impl;

import org.apache.commons.codec.digest.DigestUtils;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.lumengjun.hgshop.dao.UserMapper;
import com.lumengjun.hgshop.pojo.User;
import com.lumengjun.hgshop.service.User2Service;

@Service(interfaceClass=User2Service.class)
public class User2ServiceImpl implements User2Service{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User login(String username, String password) {
		 //进行登录操作
		return userMapper.login(username,DigestUtils.md5Hex(password));
	}

	@Override
	public User register(User user) {
	
		//进行密码加密
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		
		System.err.println(user);
		//判断是否添加成功
		if(userMapper.addUser(user)>0){
			
			//查询添加成功的用户
			return userMapper.findUserByUid(user.getUid());
		}
		return null;
	}

}
