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
		//1.加载spring配置文件，根据此创建对象
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.得到配置创建的对象
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
