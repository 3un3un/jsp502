package com.z3un3un;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionMain {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "test";
		String pw = "1234";
		
		/*
		 * 
		 * 1. 드라이버 로딩
		 * 		DB에 접근하기 위해 필요한 라이브러리가 있는지 확인
		 * 
		 * 2. 커넥션 객체를 얻어온다.
		 * 		
		 * 
		 * 
		 */
		
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 커넥션 생성
			Connection con = DriverManager.getConnection(url, id, pw);
			
			//3. 쿼리문장 준비
			String sql = "select sysdate from dual";
			//4. 쿼리문장 실행
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next(); // 다음 결과가 있는지 확인 (boolean) : 값이 여러 개일 때 while 이용한다!
			//숫자를 입력시 1부터
			//숫자 또는 결과집합의 컬럼명
			System.out.println(rs.getString(1)); //  rs.getString("sysdate");
			
			//System.out.println(con);
		} catch (ClassNotFoundException e) { //1번 예외처리
			System.out.println("드라이버 로딩실패 - 라이브러리를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) { //2번 예외처리
			System.out.println("Connection 객체생성 실패");
			e.printStackTrace();
		}
		
		
		
	}

}
