package com.easytop.psm.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testr {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TestUser t = context.getBean(TestUser.class);
		context.close();
		t.testApplicationContext();
		System.out.println();
	}
	

}
