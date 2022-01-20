package com.sist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.db.DBManager;
import com.sist.vo.EmpVO;

@Repository
public class EmpDao {
	
	public List<EmpVO> listEmp(){
		return DBManager.listEmp();
	}
}









