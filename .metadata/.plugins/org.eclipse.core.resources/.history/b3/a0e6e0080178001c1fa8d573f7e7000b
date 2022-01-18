package com.sist.exam03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloApp {

	public static void main(String[] args) {
	
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam/beans.xml");
		MessageBean mb=(MessageBean)context.getBean("mb");
		mb.sayHello("tiger");
	}

}
