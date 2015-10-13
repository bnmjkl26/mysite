package com.bit2015.mysite.dao.test;

import com.bit2015.mysite.dao.MemberDao;
import com.bit2015.mysite.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		// insert test
		// insertTest();
		
		// get test
		//getTest();
		
		// update test
		updateTest();
	}

	public static void updateTest() {
		MemberDao dao = new MemberDao();
		
		MemberVo vo = new MemberVo();
		vo.setNo( 2L );
		vo.setName( "홍길동2" );
		vo.setEmail( "gildong2@gmail.com" );
		vo.setPassword( "12345" );
		vo.setGender( "female" );
		
		dao.update(vo);
	}
	
	public static void getTest() {
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.get( "gildong@gmail.com", "1234" );
		System.out.println( vo );
	}
	
	public static void insertTest() {
		MemberDao dao = new MemberDao();
		
		MemberVo vo = new MemberVo();
		vo.setName( "홍길동" );
		vo.setEmail( "gildong@gmail.com" );
		vo.setPassword( "1234" );
		vo.setGender( "male" );
		
		dao.insert(vo);
	}
		
}
