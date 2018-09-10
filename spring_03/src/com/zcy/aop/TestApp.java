package com.zcy.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	@Test
	public void testDemo()
	{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}
}
