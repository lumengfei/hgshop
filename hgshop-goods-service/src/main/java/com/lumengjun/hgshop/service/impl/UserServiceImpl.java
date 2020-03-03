package com.lumengjun.hgshop.service.impl;




import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.lumengjun.hgshop.dao.UserMapper;
import com.lumengjun.hgshop.pojo.User;
import com.lumengjun.hgshop.service.UserService;




/**
 * 
 * @author ASUS
 *
 */
@Service(interfaceClass=UserService.class,version="1.0.0")
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public boolean login(String userName, String passWord) {
		User user = userMapper.login(userName,passWord);
		if(user!=null){
			return true;
		}
		return false;
		
	}

}
