package com.zcy.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {

	//�õ�dao����
	//1.����dao��������
	//ʹ��ע�ⷽʽ����Ҫset����
	//��dao��������ʹ��ע�⣬��ɶ���ע��
//	@Autowired
//	private UserDao userDao;
	//name����ֵ����дע�ⴴ��dao�����valueֵ
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void add()
	{
		System.out.println("service.....");
		userDao.add();
	}
}
