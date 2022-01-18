package com.sist.exam06;

public class Person {
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void info() {
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
	}
	
}
