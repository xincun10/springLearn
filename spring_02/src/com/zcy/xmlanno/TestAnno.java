package com.zcy.xmlanno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {

	@Test
	public void test()
	{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext2.xml");
		BookService bookService = (BookService) context.getBean("bookService");
		bookService.buy();
	}
}
