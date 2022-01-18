package com.sist.exam04;

public class DeptDao {
	private Dept dept;

	public DeptDao(Dept dept) {
		super();
		this.dept = dept;
	}
	
	public void insert() {
		System.out.println("다음의 부서를 등록하였습니다");
		System.out.println(dept);
	}
}
