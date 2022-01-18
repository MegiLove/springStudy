package com.sist.exam13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam12/beans12.xml");
		SystemMonitor sm= (SystemMonitor)context.getBean("systemMonitor");
			sm.monitor();
	}
}
