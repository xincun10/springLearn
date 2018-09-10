package com.zcy.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zcy.bean.Bean3;
import com.zcy.property.Book;
import com.zcy.property.Person;
import com.zcy.property.PropertyDemo1;

public class TestIOC {

	@Test
	public void testUser()
	{
		//1.����spring�����ļ������ݴ˴�������
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.�õ����ô����Ķ���
		Person person = (Person) context.getBean("person");
		person.test();
//		UserService userService = (UserService) context.getBean("userService");
//		userService.add();
//		Book book = (Book) context.getBean("book");
//		book.test();
//		PropertyDemo1 demo1 = (PropertyDemo1) context.getBean("demo1");
//		demo1.test1();
//		User user = (User) context.getBean("user");
//		System.out.println(user);
//		user.add();
//		Bean3 bean3 = (Bean3) context.getBean("bean3");
//		System.out.println(bean3);
	}
}
