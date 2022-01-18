package com.sist.exam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam06/beans06.xml");
		Person person=(Person)context.getBean("person");
		person.info();
	}

}
