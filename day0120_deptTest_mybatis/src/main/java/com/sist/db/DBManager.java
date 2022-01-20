package com.sist.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

public class DBManager {
	
	//mybatis �������Ͽ� �����ϱ� ���� SqlSesscionFactory ������ �����մϴ�.
	//�� ������ ��ü���̵� ������ �� �ֵ��� static������ ����ϴ�.
	private static SqlSessionFactory sqlMapper;
	
	
	//���α׷� ����ʰ� ���ÿ� �ڵ����� �����Ͽ� 
	//mybatis ���������� �о� ���̱� ���Ͽ� static ���� �ڵ��մϴ�.
	static {
		try { //������ �о� �鿩�� �ϴ� ����ó���� �� �ݴϴ�.
			
			//mybatis ���������� ��Ʈ���� �о���Դϴ�.
			Reader reader 
			= Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			
			//mybatis ���������� ��Ʈ���� ����
			//mybatis�� ���� sql�� ����� �� �ִ� 
			//SqlSessionFactory ��ü�� �����մϴ�.
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			
			//��Ʈ���� �ݾ� �ݴϴ�.
			reader.close();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
	
	
	//mybatis ���������� Ư�� sql(dept��� ���ӽ����̽��� selectAll�̶�� 
	//id�� ����)�� ��û�ϴ� �޼ҵ带 �����մϴ�.
	public static List<DeptVO> listAll(){
		
		//mybatis �������Ͽ� �ִ� sql�� ����ϱ� ���Ͽ� 
		//SqlSessionFactory�� ���Ͽ� SelSession��ü�� ���ɴϴ�.
		SqlSession session= sqlMapper.openSession();
		
		//SqlSession�� ���� sql�� �����մϴ�.
		//SqlSession���� crud�� ����
		//insert, update, delete, select �޼ҵ���� �ֽ��ϴ�.
		//������ selectList�� �̿��մϴ�.
		//�̶� �Ű������� mybatis�������Ͽ� �ִ� ���ӽ����̽��� id�� ������ �ݴϴ�.
		List<DeptVO> list  =session.selectList("dept.selectAll");
		
		//session�� ����� �Ŀ��� session�� �ݾ� �ݴϴ�.
		session.close();
		
		return list;
	}
	
	
	public static DeptVO getDept(int dno) {
		SqlSession session = sqlMapper.openSession();
		DeptVO d= session.selectOne("dept.selectDept", dno);
		session.close();
		return d;
	}
	
	
	public static int insert(DeptVO d) {
		int re = -1;
		SqlSession session = sqlMapper.openSession();
		re = session.insert("dept.insert", d);
		//�����ͺ��̽��� ������ �ִ� sql(insert,update,delete)�� ������ ������ �ݵ��
		//session.commit()�̰ų� rollback()�޼ҵ带 ȣ���ؾ� �մϴ�.
		if(re == 1) {
			session.commit();
		}
		session.close();
		return re;
	}
	
	public static int updateDept(DeptVO d) {
		int re = -1;
		SqlSession session = sqlMapper.openSession(true);
		re =session.update("dept.update", d);
		//session.commit();
		session.close();
		return re;
	}
	
	public static int deleteDept(int dno) {
		int re = -1;
		SqlSession session = sqlMapper.openSession(true);
		re = session.delete("dept.delete", dno);
		session.close();
		return re;
	}
	
	
	//������ �ڵ带 �ϼ��� ���ϴ�.
	//�ϼ��ϸ� "3"
	public static List<EmpVO> listEmp(){
		SqlSession session = sqlMapper.openSession();
		List<EmpVO> list = session.selectList("emp.selectAll");
		session.close();
		return list;
	}
}














