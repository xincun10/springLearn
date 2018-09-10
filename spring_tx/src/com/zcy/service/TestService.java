package com.zcy.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

	@Test
	public void testDemo()
	{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		OrdersService userService = (OrdersService) context.getBean("ordersService");
		userService.accountMoney();
	}
}
