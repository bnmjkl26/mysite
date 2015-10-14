package com.bit2015.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.mysite.vo.GuestbookVo;

public class GuestbookDao {
	private Connection getConnection() throws SQLException {
		
		Connection connection = null;
		
		try {
			//1.드라이버 로딩
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
		
			//2.커넥션 만들기(ORACLE DB)
			String dbURL  = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection( dbURL, "webdb", "webdb" );
			
		} catch( ClassNotFoundException ex ){
			System.out.println( "드라이버 로딩 실패-" + ex );
		} 
		
		return connection;
	}
	
	public void delete( GuestbookVo vo ) {
		try {
			//1. Connection 가져오기
			Connection connection = getConnection();
			
			//2. Statement 준비
			String sql = 
				" delete" +
				"   from guestbook" + 
				"  where no=? and password=?";
			
			PreparedStatement pstmt = connection.prepareStatement( sql );
			
			//Statement 를 사용할 때,
			/*
			String sql2 = 
					" delete" +
					"   from guestbook" + 
					"  where no=" + vo.getNo() +
					"    and password=" + vo.getPassword();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate( sql2 );
			*/
			
			//3. binding
			pstmt.setLong( 1, vo.getNo() );
			pstmt.setString( 2, vo.getPassword() );
			
			//4. query 실행
			pstmt.executeUpdate();
			
			//5. 자원정리
			pstmt.close();
			connection.close();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류-" + ex );
		}		
	}
	
	public void insert( GuestbookVo vo ) {
		try {
			//1. Connection 가져오기
			Connection connection = getConnection();
			
			//2. Statement 준비
			String sql = 
				" insert" +
				"   into guestbook" + 
				" values( guestbook_seq.nextval, ?, ?, ?, SYSDATE )";
			PreparedStatement pstmt = connection.prepareStatement( sql );
			
			//3. binding
			pstmt.setString( 1, vo.getName() );
			pstmt.setString( 2, vo.getPassword() );
			pstmt.setString( 3, vo.getMessage() );
			
			//4. query 실행
			pstmt.executeUpdate();
			
			//5. 자원정리
			pstmt.close();
			connection.close();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류-" + ex );
		}
	}
	
	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		
		try {
			//1. 커넥션 만들기(ORACLE DB)
			Connection connection = getConnection();
			
			//2. Statement 생성
			Statement stmt = connection.createStatement();
			
			//3. SQL문 실행
			String sql =
				"   select no,"
			  + "          name,"
			  + "          message,"
			  + "          to_char( reg_date, 'yyyy-MM-dd hh:mm:ss' )"
			  + "     from guestbook"
			  + " order by reg_date desc";
			ResultSet rs = stmt.executeQuery( sql );
			
			//4. row 가져오기
			while( rs.next() ) {
				Long no = rs.getLong( 1 );
				String name = rs.getString( 2 );
				String message = rs.getString( 3 );
				String regDate = rs.getString( 4 );
				
				GuestbookVo vo = new GuestbookVo();
				vo.setNo( no );
				vo.setName( name );
				// vo.setPassword(password);
				vo.setMessage( message );
				vo.setRegDate( regDate );
				
				list.add( vo );
			}
			
			//6. 자원 정리
			rs.close();
			stmt.close();
			connection.close();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류-" + ex );
		}
		
		return list;
	}
}
