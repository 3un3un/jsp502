package com.z3un3un;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.z3un3un.dto.Job;

public class DBConnectionSelf {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "test";
		String pw = "1234";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Job> list = new ArrayList<>(); 
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
			String sql = "select * from job";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Job job = new Job();
				job.setJobCode(rs.getString(1));
				job.setJobName(rs.getString(2));
				System.out.print(rs.getString(1) + " ");
				System.out.println(rs.getString(2));
				list.add(job);
				
			}
			System.out.println("=====================");
			System.out.println(list);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 객체생성 실패");
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) { rs.close(); }
				if(stmt!=null) { stmt.close(); }
				if(con!=null) { con.close(); }
			} catch (SQLException e) {
				System.out.println("자원 해제중 예외사항이 발생하였습니다.");
				e.printStackTrace();
			}
			
		}
		


	}

}
