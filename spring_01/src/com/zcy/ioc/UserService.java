package com.zcy.ioc;

public class UserService {

	//1.����dao��������
	private UserDao userDao;
	//2.����set����
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add()
	{
		System.out.println("service....");
		//��service����õ�dao����󣬲��ܵ���dao����ķ���
//		UserDao dao = new UserDao();
//		dao.add();
		userDao.add();
	}

}