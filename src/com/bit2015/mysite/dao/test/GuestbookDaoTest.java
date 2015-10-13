package com.bit2015.mysite.dao.test;

import java.util.List;

import com.bit2015.mysite.dao.GuestbookDao;
import com.bit2015.mysite.vo.GuestbookVo;



public class GuestbookDaoTest {

	public static void main(String[] args) {
		//insert Test
		//insertTest();
	
		//delete Test
		deleteTest();
		
		//getList Test
		getListTest();
	}

	public static void getListTest() {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList();
		
		for( GuestbookVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void insertTest() {
		GuestbookDao dao = new GuestbookDao();
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName( "둘리" );
		vo.setPassword( "1234" );
		vo.setMessage( "호이~" );
		
		dao.insert( vo );
	}
	
	public static void deleteTest() {
		GuestbookDao dao = new GuestbookDao();
		
		GuestbookVo vo = new GuestbookVo();
		vo.setNo( 2L );
		vo.setPassword( "1234" );
		
		dao.delete( vo );
	}
}
