package com.sist.exam17;


public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		System.out.println("������ ������");
	}
	
	public Person(String name, int age) {
		this.name=name;
		this.age= age;
		System.out.println("�Ű������� ���� ������ ������");
	}
	
	
	public void sayHello() {
		System.out.println("hello,"+name+"!"+"����:"+age);
	}
}