package com.cafe24.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext ac =						// 이 xml읽어서 자기(컨테이너)안에 객체 만들어라
				new ClassPathXmlApplicationContext("config/applicationContext.xml");

		ProductService ps = ac.getBean( ProductService.class ); //야 너 안에 이 클래스 타입 객체 내놔!
		ProductVo vo = ps.find("TV");
		System.out.println("[main] " + vo);
	}
 
}
