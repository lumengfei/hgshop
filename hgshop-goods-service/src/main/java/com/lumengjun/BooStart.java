package com.lumengjun;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BooStart {

public static void main(String[] args) throws IOException {
		
		System.err.println("启动====");
		//加载配置文件
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
		System.err.println("加载文件====");
		//启动加载
		context.start();
		System.err.println("加载完成====");
		//进行阻塞
		System.in.read();
		
	}
	
}
