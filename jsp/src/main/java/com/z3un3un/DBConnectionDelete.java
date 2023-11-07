package com.z3un3un;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionDelete {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "test";
		String pw = "1234";
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "delete " 
					+ "from job where job_code = ?";
			PreparedStatement pstms = conn.prepareStatement(sql);
			
			pstms.setString(1, "99");
			
			int res = pstms.executeUpdate();
			System.out.println(res + "건 생성되었습니다.");
			
		} catch (ClassNotFoundException e) {
			System.out.println("라이브러리 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 실패");
			e.printStackTrace();
		}
		
		
	}

}
