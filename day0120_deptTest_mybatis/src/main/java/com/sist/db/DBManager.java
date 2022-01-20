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
	
	//mybatis 설정파일에 접근하기 위한 SqlSesscionFactory 변수를 선언합니다.
	//이 변수에 객체없이도 접근할 수 있도록 static변수로 만듭니다.
	private static SqlSessionFactory sqlMapper;
	
	
	//프로그램 실행됨과 동시에 자동으로 실행하여 
	//mybatis 설정파일을 읽어 들이기 위하여 static 블럭에 코딩합니다.
	static {
		try { //파일을 읽어 들여야 하니 예외처리를 해 줍니다.
			
			//mybatis 설정파일을 스트림을 읽어들입니다.
			Reader reader 
			= Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			
			//mybatis 설정파일의 스트림을 통해
			//mybatis를 통해 sql를 사용할 수 있는 
			//SqlSessionFactory 객체를 생성합니다.
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			
			//스트림을 닫아 줍니다.
			reader.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	
	//mybatis 설정파일의 특정 sql(dept라는 네임스페이스의 selectAll이라는 
	//id를 갖는)을 요청하는 메소드를 정의합니다.
	public static List<DeptVO> listAll(){
		
		//mybatis 설정파일에 있는 sql를 사용하기 위하여 
		//SqlSessionFactory를 통하여 SelSession객체를 얻어옵니다.
		SqlSession session= sqlMapper.openSession();
		
		//SqlSession을 통해 sql를 실행합니다.
		//SqlSession에는 crud를 위한
		//insert, update, delete, select 메소드들이 있습니다.
		//지금은 selectList를 이용합니다.
		//이때 매개변수로 mybatis설정파일에 있는 네임스페이스와 id를 전달해 줍니다.
		List<DeptVO> list  =session.selectList("dept.selectAll");
		
		//session을 사용한 후에는 session을 닫아 줍니다.
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
		//데이터베이스에 변경이 있는 sql(insert,update,delete)를 실행할 때에는 반드시
		//session.commit()이거나 rollback()메소드를 호출해야 합니다.
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
	
	
	//나머지 코드를 완성해 봅니다.
	//완성하면 "3"
	public static List<EmpVO> listEmp(){
		SqlSession session = sqlMapper.openSession();
		List<EmpVO> list = session.selectList("emp.selectAll");
		session.close();
		return list;
	}
}














