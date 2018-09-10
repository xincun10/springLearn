package com.zcy.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {

	@Test
	public void testService()
	{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService user = (UserService) context.getBean("userService");
		System.out.println(user);
		user.add();
	}
	
	@Test
	public void testUser()
	{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
		user.add();
	}
}
