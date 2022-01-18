package com.sist.exam01;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MessageBean mb= new MessageBean(); 	강한의존관계
		MessageBeanJP mb= new MessageBeanJP();
		mb.sayHello("tiger");
	}

}
