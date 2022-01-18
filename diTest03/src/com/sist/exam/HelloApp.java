package com.sist.exam;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.sist.dao.MemberDAO;

public class HelloApp {

	public static void main(String[] args) {
	
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam/beans.xml");
		MemberDAO dao=(MemberDAO)context.getBean("dao");
		dao.insert();
	}

}
