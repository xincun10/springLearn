package com.zcy.ioc;

public class User {

	public void add()
	{
		System.out.println("add...");
	}
	public static void main(String[] args)
	{
		//ԭʼ����
		User user = new User();
		user.add();
	}
}
