package com.z3un3un;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionEmp {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "test";
		String pw = "1234";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
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
			con = DriverManager.getConnection(url, id, pw);
			
			//3. 쿼리문장 준비
			String sql = "select emp_id, emp_name, emp_no from employee";
			//4. 쿼리문장 실행
			stmt = con.createStatement();
			
			//* stmt.executeQuery(sql);
			//select문장을 실행할 경우 ResultSet을 반환한다.
			//* stmt.executeUpdate(sql);
			//update, insert, delete 의 경우 int 타입을 반환한다.
			//	-> 실행결과 몇 건이 처리되었는지를 알려준다.
			
			rs = stmt.executeQuery(sql);
			
			// 다음 결과가 있는지 확인 (boolean) : 값이 여러 개일 때 while 이용한다!
			while(rs.next()) { 
				//숫자를 입력시 1부터
				//숫자 또는 결과집합의 컬럼명
				//System.out.println("emp_id"); //문자열로 입력시 칼럼명으로 가져오기
				System.out.print(rs.getString(1) + " "); //칼럼 index로 가져오기
				System.out.print(rs.getString(2) + " ");
				System.out.println(rs.getString(3) + " ");
			}
			
			//System.out.println(con);
		} catch (ClassNotFoundException e) { //1번 예외처리
			System.out.println("드라이버 로딩실패 - 라이브러리를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) { //2번 예외처리
			System.out.println("Connection 객체생성 실패");
			e.printStackTrace();
		} finally {
			try {
				//역순으로 닫기
				if(rs != null) { rs.close(); }
				if(stmt != null) {stmt.close(); }
				if(con != null) {con.close(); }
				
			} catch(Exception e) {
				System.out.println("자원 해제중 예외사항이 발생하였습니다.");
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
