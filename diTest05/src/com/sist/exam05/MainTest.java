package com.sist.exam05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam05/beans05.xml");
		 JobExecutor je=(JobExecutor)context.getBean("je");
		je.pro();
		}

}
