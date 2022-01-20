package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.sist.db.ConnectionProvider;
import com.sist.vo.DeptVO;

@Repository
public class DeptDAO {
	
	
	
	public DeptVO getDept(int dno) {
		DeptVO d = null;
		try {
			String sql  = "select * from dept where dno=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				d = new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return d;
	}
	
	public int insert(DeptVO d) {
		int re = -1;
		try {
			String sql = "insert into dept values(?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			re =pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	public int update(DeptVO d) {
		int re = -1;
		try {
			String sql = "update dept set dname=?,dloc=? where dno=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getDname());
			pstmt.setString(2, d.getDloc());
			pstmt.setInt(3, d.getDno());
			re =pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	public int delete(int dno) {
		int re = -1;
		try {
			String sql = "delete dept where dno=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, dno);
			re =pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public ArrayList<DeptVO> listAll(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept order by dno";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, stmt,rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
}
