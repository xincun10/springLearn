package com.zcy.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {

	//得到dao对象
	//1.定义dao类型属性
	//使用注解方式不需要set方法
	//在dao属性上面使用注解，完成对象注入
//	@Autowired
//	private UserDao userDao;
	//name属性值里面写注解创建dao对象的value值
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void add()
	{
		System.out.println("service.....");
		userDao.add();
	}
}
