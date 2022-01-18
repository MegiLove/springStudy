package com.sist.exam05;

public class JobExecutor {
 public JobExecutor(String name, int seconds) {
	 System.out.println("생성자 호출1");
 }
 
 public JobExecutor(String name, long seconds) {
	 System.out.println("생성자 호출2");
 }
 
 public JobExecutor(String name, String seconds) {
	 System.out.println("생성자 호출3");
 }
 
 public void pro() {
	 System.out.println("JobExecutor의 pro입니다");
 }
}
