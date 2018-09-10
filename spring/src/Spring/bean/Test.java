package Spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String args[]) throws BeansException
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object o = factory.getBean("v");
		Moveable m = (Moveable)o;
		m.run();
	}
}
