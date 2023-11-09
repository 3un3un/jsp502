package com.z3un3un.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.dto.BoardDto;
// DBConnPool
//	:톰캣에서 제공해주는 기능을 사용하여 커넥션풀이라는 공간에 커넥션 객체를 미리 생성해놓고 사용하는 객체
//  main메서드 사용이 불가능, 서버가 실행되어야 사용이 가능
//  만약, main 메서드를 이용해서 테스트를 하고 싶다면 상속받는 객체를 DBConnection으로 변경해야 한다.
public class BoardDao extends DBConnPool {

	public List<BoardDto> getList() {
		List<BoardDto> list = new ArrayList<>();
		
		try {
			String sql = "select * from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setId(rs.getString(4));
				dto.setPostdate(rs.getString(5));
				dto.setVisitcount(rs.getString(6));
				
				list.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return list;
		
	}
	
	public List<BoardDto> getDetail(String num) {
		List<BoardDto> detail_list = new ArrayList<>();
		
		try {
			String sql = "select * from board where=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setId(rs.getString(4));
				dto.setPostdate(rs.getString(5));
				dto.setVisitcount(rs.getString(6));
				
				detail_list.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return detail_list;
		
	}
		
	
	
	
}
