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
	
	//다음 주에 다시!
//	public int insertBoard(BoardDto dto) {
//		
//		
//		
//	}
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
	
	public BoardDto getOne(String num) {
		BoardDto dto = null;
		String sql = "select * from board where num =?";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				dto = new BoardDto();
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setId(rs.getString(4));
				dto.setPostdate(rs.getString(5));
				dto.setVisitcount(rs.getString(6));
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return dto;
		
	}
	/**
	 * 
	 * 게시글의 조회수를 1 증가시켜준다.
	 * insert, update, delete의 반환 타입은 int(몇 건이 처리되었는지 반환)
	 * 반환타입은 int로 설정
	 * 
	 */
	public int visitcountUp(String num) {
		String sql = "update board\r\n"
				+ "set visitcount = visitcount+1\r\n"
				+ "where num = ?";
		int res = 0;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			res = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return res;
		
	}
	
	public int deleteBoard(String num) {
		String sql = "delete \r\n"
				+ "from board\r\n"
				+ "where num = ?";
		int res = 0;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			res = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return res;
		
	}
		
	
	
	
}
