package com.z3un3un.dao;


import java.sql.SQLException;

import com.z3un3un.common.DBConnPool;
import com.z3un3un.dto.MemberDto;

public class MemberDao extends DBConnPool{
	
	public MemberDto login(String id, String pass) {
		MemberDto memberDto = new MemberDto();
		String sql = "select *\r\n"
				+ "from member\r\n"
				+ "where id=?\r\n"
				+ "and pass=?";
		//입력받은 사용자 정보를 DB로부터 조회
		try {
			
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			//id, pw는 중복되지 않으니까 if문 사용한다!
			if(rs.next()) {
				//로그인 성공
				memberDto.setId(rs.getString(1));
				memberDto.setName(rs.getString(3));
				memberDto.setRegidate(rs.getString(4));
				
				//사용자정보를 MemberDto객체에 담아서 반환
				return memberDto;
			} else {
				//로그인 실패

				
				return null;
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
	}
	//회원가입
	public int register(String id, String name, String pass, String email) {
		int res = 0;
		String sql = "insert into member (id, pass, name, regidate, email)\r\n"
				+ "values(?, ?, ?, sysdate, ? )";
		
		
		try {
			if(id !=null && name != null && pass != null && email != null) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
				pstmt.setString(3, name);
				pstmt.setString(4, email);
				res = pstmt.executeUpdate();
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return res;
		
		
		
		
		
	}


}
