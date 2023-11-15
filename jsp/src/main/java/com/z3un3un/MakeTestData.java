package com.z3un3un;

import java.sql.SQLException;

import com.z3un3un.common.DBConnection;

/**
 * JDBC를 활용한 테스트 데이터 생성
 * board 테이블에 테스트 데이터를 생성한다.
 */
public class MakeTestData extends DBConnection{
	
	public int insert() {
		int res = 0;
		String sql = "insert into board (num, title, content, id, postdate)\r\n"
				+ "values (seq_board_num.nextval,"
				+ " '제목'||seq_board_num.currval||'입니다',"
				+ " '내용'||seq_board_num.currval||'입니다',"
				+ " 'test',"
				+ " sysdate)";
		try {
			pstmt = con.prepareStatement(sql);

			//입력 실행
			res = pstmt.executeUpdate();
			System.out.println(res+"건 입력되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 자바프로그램 실행
	 * 
	 */
	public static void main(String[] args) {
		MakeTestData d = new MakeTestData();
		for(int i=0; i<100; i++) {
			d.insert();
		}
		//자원 반납
		d.close();
	}

}
