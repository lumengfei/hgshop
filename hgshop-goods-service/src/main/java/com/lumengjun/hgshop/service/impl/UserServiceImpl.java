package com.lumengjun.hgshop.service.impl;




import org.apache.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lumengjun.hgshop.config.AdminProperties;

import com.lumengjun.hgshop.service.UserService;




/**
 * 
 * @author ASUS
 *
 */
@Service(interfaceClass=UserService.class,version="1.0.0")
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	AdminProperties adminProperties;
	
	@Override
	public boolean login(String userName, String passWord) {
		
		return (adminProperties.getName().equals(userName) && adminProperties.getPassword().equals(passWord));
		
	}

}
