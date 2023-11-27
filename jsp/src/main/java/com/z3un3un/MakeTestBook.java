package com.z3un3un;

import java.sql.SQLException;

import com.z3un3un.common.DBConnection;


/**
 * JDBC를 활용한 테스트 데이터 생성 
 * board 테이블에 테스트 데이터를 생성 합니다
 */
public class MakeTestBook extends DBConnection{
	
	/**
	 * board 테이블에 데이터를 삽입
	 */
	public void insert() {
		// 입력 쿼리
		/*
		 * String sql = "insert into book \r\n" + "      values(SEQ_BOARD_NUM.nextval" +
		 * "					, '책'||SEQ_BOARD_NUM.currval" +
		 * "					, 'N'" +
		 * "					, '작가'||SEQ_BOARD_NUM.currval)";
		 */
		
		String sql = "INSERT INTO BOOK "
				+ "VALUES (SEQ_BOARD_NUM.nextval,\r\n"
				+ "'책'||SEQ_BOARD_NUM.currval,\r\n"
				+ "'N',\r\n"
				+ "'작가'||SEQ_BOARD_NUM.currval)";
		

		try {
			pstmt = con.prepareStatement(sql);
			
			// 입력 실행
			int res = pstmt.executeUpdate();
			System.out.println(res + "건 입력 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 자바 프로그램 실행
	 * @param args
	 */
	public static void main(String[] args) {
		MakeTestBook d = new MakeTestBook();
		for(int i=0; i<10; i++) {
			d.insert();
		}
		// 자원 반납
		d.close();
	}
}
