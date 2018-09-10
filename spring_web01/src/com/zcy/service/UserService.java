package com.zcy.service;

import com.zcy.dao.UserDao;

public class UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		userDao.add();
	}


	public void add()
	{
		System.out.println("service....");
	}
}
