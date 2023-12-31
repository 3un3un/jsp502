package com.z3un3un;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionInsert {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "test";
		String pw = "1234";
		
		Connection conn = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 커넥션 생성
			conn = DriverManager.getConnection(url, id, pw);
			
			
			//3. 쿼리 생성 (인파라미터 ?)
			String sql = "insert into job values (?, ?)";
			
			//4. pstmt 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//5. 인파라미터 세팅
			//쿼리상에 ?로 작성된 부분을 값으로 변경
			pstmt.setString(1, "99"); //첫 번째 물음표
			pstmt.setString(2, "값99"); //두 번째 물음표
			
			int res = pstmt.executeUpdate();
			System.out.println(res + "건 생성되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("라이브러리를 확인해주세요.");
			e.printStackTrace();
			
			
		} catch (SQLException e) {
			System.out.println("Connection 연결 실패");
			e.printStackTrace();
		}
		
	}

}
