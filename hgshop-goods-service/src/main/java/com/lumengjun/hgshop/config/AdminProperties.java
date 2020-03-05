package com.lumengjun.hgshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:hgshop-admin.properties")
public class AdminProperties {

	@Value("${admin.name}")
	String name;
	
	
	@Value("${admin.pwd}")
	String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Properties [name=" + name + ", password=" + password + "]";
	}
	public AdminProperties(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public AdminProperties() {
		super();
	}
	
	
	
}
