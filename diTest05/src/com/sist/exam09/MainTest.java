package com.sist.exam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam09/beans09.xml");
		GoodsVO goods=(GoodsVO)context.getBean("goods");
		goods.info();
	}

}
