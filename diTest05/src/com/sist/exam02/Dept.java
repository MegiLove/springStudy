package com.sist.exam02;

public class Dept {
	private int dno;
	private String dname;
	private String dloc;
	public Dept(int dno, String dname, String dloc) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.dloc = dloc;
	}
	
	@Override
	public String toString() {
		return "Dept [dno=" + dno + ", dname=" + dname + ", dloc=" + dloc + "]";
	}
	
	
}
