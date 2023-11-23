package com.z3un3un;

import java.sql.SQLException;

import com.z3un3un.common.DBConnection;

/**
 * JDBC를 활용한 테스트 데이터 생성
 * board 테이블에 테스트 데이터를 생성한다.
 */
public class MakeTestData2 extends DBConnection{
	public static void main(String[] args) {
		MakeTestData2 mtd = new MakeTestData2();
		mtd.insert();
		mtd.close();
	}
	public int insert() {
		int res = 0;
		try {
			
			for(int i=7; i<=100; i++) {
				pstmt = con.prepareStatement("insert into book (no, title, rentyn, author)\r\n"
						+ "values ("+i+", '책"+i+"', 'N', '작가"+i+"')");
				//입력 실행
				res = pstmt.executeUpdate();
				System.out.println(res+"건 입력되었습니다.");
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}


}
