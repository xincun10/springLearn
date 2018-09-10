package com.zcy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {

	//�ڷ�������ʹ��ע�������ǿ����
	@Before(value="execution(* com.zcy.aop.Book.*(..))")
	public void before1()
	{
		System.out.println("before1.....");
	}
}
