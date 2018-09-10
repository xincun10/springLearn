package com.zcy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {

	//在方法上面使用注解完成增强配置
	@Before(value="execution(* com.zcy.aop.Book.*(..))")
	public void before1()
	{
		System.out.println("before1.....");
	}
}
