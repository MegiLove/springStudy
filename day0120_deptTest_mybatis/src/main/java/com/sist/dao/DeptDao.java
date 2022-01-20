package com.sist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.db.DBManager;
import com.sist.vo.DeptVO;

@Repository
public class DeptDao {
	public List<DeptVO> listAll(){
		return DBManager.listAll();
	}
	
	
	public DeptVO getDept(int dno) {
		return DBManager.getDept(dno);
	}
	
	public int insertDept(DeptVO d) {
		return DBManager.insert(d);
	}
	
	public int updateDept(DeptVO d) {
		return DBManager.updateDept(d);
	}
	
	
	public int deleteDept(int dno) {
		return DBManager.deleteDept(dno);
	}
}











