package com.zcy.anno;

import org.springframework.stereotype.Component;

@Component(value="user") //µÈÍ¬ÓÚ<bean id="user" class=""/>
public class User {

	public void add()
	{
		System.out.println("add.....");
	}
}
