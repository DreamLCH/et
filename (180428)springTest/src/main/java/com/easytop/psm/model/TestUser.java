package com.easytop.psm.model;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import junit.framework.Assert;

@Component
public class TestUser {
	
	@Autowired
	private User1 user;

	
	@Test
	public void testApplicationContext() {
		
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		user = (User1)context.getBean("user");
		System.out.println(user);
		
		
		Person person =context.getBean(Person.class);
		System.out.println(person);
		Assert.assertNotNull(user);
		System.out.println(user);*/
		
	}
}
